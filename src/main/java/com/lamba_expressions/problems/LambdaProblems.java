package com.lamba_expressions.problems;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

interface OddEven{
    int check(int n);
}
interface Product{
    int multiply(int a, int b);
}

interface ThreadExample extends Runnable{
    void run();
}

interface Calculator{
    int operate(int a, int b);
}
interface StringOperation{
    String toUpper(String str);
    default String toLower(String str){
        return str.toLowerCase();
    }
}
public class LambdaProblems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int n = sc.nextInt();
        //Odd or Even
        OddEven num1 =  (num) -> (num % 2 == 0 ? 1 : 0);
        if(num1.check(n) == 1){
            System.out.println(n + " is Even");
        }
        else{
            System.out.println(n + " is Odd");
        }
        System.out.print("Enter second Number: ");

        //Product of two numbers
        int m = sc.nextInt();
        Product mul = (a, b) -> a * b;
        System.out.println("Product is: "+mul.multiply(m, n));

        List<String> list = Arrays.asList("Yashavanth", "Pavan", "Harshitha", "Priyanka");
        //Using method reference
        list.sort(String::compareTo);
        System.out.println("Sorted List using method reference: ");
        list.forEach(System.out::println);

        System.out.println("Sorting using comparator:");
        list.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
       for(String s: list){
           System.out.println(s);
       }

       System.out.println("Runnable using lambda expression:");
        ThreadExample threadExample = () -> {
           System.out.println("Hello from Lambda Thread");
        };
       Thread ts = new Thread(threadExample);
       threadExample.run();

       System.out.print("Enter a String: ");
       String input = sc.next();
       Function<String, String> reverse = s -> new StringBuilder(s).reverse().toString();
       String reversed = reverse.apply(input);

       System.out.println("Original: " + input);
       System.out.println("Reversed: " + reversed);

       Calculator add =(a, b) -> a + b;
       System.out.println(add.operate(2, 4));
       Calculator sub = (a, b) -> a - b;
       System.out.println(sub.operate(3, 2));

       Calculator prod = (a, b) -> a * b;
       System.out.println(prod.operate(2, 4));

       List<String> names = Arrays.asList("Yashavanth", "Pavan", "Harshitha", "Priyanka", "");
        System.out.println("Names size: "+names.size());
        Predicate<String> isNotEmpty = str -> !str.isEmpty();

        List<String> filtered = names.stream().filter(isNotEmpty).toList();
        System.out.println("Filtered Size: "+filtered.size());
        filtered.forEach(System.out::println);

        System.out.print("Enter a value: ");
        String number = sc.next();
        Function<String, Integer>  stringToInteger = str -> {
           return Integer.parseInt(str);
        };
        System.out.println("String to Integer: "+stringToInteger.apply(number));

        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        Function<Integer, String> intToString = n1 ->  {
           return String.valueOf(n1);
        };
        System.out.println("Inreger to String: " + intToString.apply(num));

        Consumer<String> printUpperCase = str -> {
            System.out.println(str.toUpperCase());
        };
        printUpperCase.accept(input);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Consumer<Integer> printSquare = num2 -> {
             System.out.println(num2+" Square is: "+num2 * num2);
        };
        numbers.forEach(printSquare);
    }
}
