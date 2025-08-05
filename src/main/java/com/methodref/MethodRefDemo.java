package com.methodref;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Printable {
    void print(String msg);
}

public class MethodRefDemo {

    public void display(String msg){
        msg = msg.toUpperCase();
        System.out.println(msg);
    }
    public static int addition(int a, int b){
        return a + b;
    }
    public static void main(String[] args) {
        //1. Static method reference
        //using lambda expression
        Function<Integer, Double> function = (input) -> Math.sqrt(input);
       System.out.println(function.apply(4));

       //using method reference
        Function<Integer, Double> function1 = Math::sqrt;
        System.out.println(function1.apply(25));

        //using lambda expression
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> addition(a, b);
        System.out.println(biFunction.apply(2, 4));

        //using method reference
        BiFunction<Integer, Integer, Integer> biFunctionMethodRef = MethodRefDemo::addition;;
        System.out.println(biFunctionMethodRef.apply(4, 5));

        //2. Instance method reference
        MethodRefDemo methodRefDemo = new MethodRefDemo();
        //using lambda expression
        Printable printable = (msg) -> methodRefDemo.display(msg);
        printable.print("hello world");

        //using method reference
        Printable printable1 = methodRefDemo::display;
        printable1.print("yashavanth");

        //3. Arbitrary method reference
        //using lambda expression
        Function<String, String > stringFunction = (input) -> input.toLowerCase();
        System.out.println(stringFunction.apply("YASHAVANTH"));

        //using method reference
        Function<String, String> stringFunction1 = String::toLowerCase;
        System.out.println(stringFunction1.apply("PAVAN C J"));

        //4. Reference to a constructor
        List<String> fruits = new ArrayList<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Orange");

        //using lambda expression
        Function<List<String>, Set<String>> setFunction = (fruitsList) -> new HashSet<>(fruitsList);
        System.out.println(setFunction.apply(fruits));

        //using method reference
        Function<List<String>, Set<String>> setFunction1 = HashSet::new;
        System.out.println(setFunction1.apply(fruits));
    }
}
