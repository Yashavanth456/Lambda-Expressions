package com.function;

import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionDemo {
    public static void main(String[] args) {

        //Function interface
        Function<String, Integer> function = (String s) -> s.length();
        System.out.println(function.apply("Yashavanth"));

        //Consumer Interface
        Consumer<String> consumer = (String s) -> System.out.println(s);
        consumer.accept("Hello world");

        //Supplier Interface
        Supplier<LocalDateTime> supplier = () -> LocalDateTime.now();
       System.out.println( supplier.get());

       //Runnable Interface
        Runnable runnable = () -> System.out.println("runnable called using lambda");
        Thread thread = new Thread(runnable);
        thread.start();

        //Predicate
        Predicate<String> isLong = str -> str.length() > 5;

        System.out.println(isLong.test("Hello"));     // false
        System.out.println(isLong.test("Functional")); // true
    }
}
