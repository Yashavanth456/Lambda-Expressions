package com.streamapi;

import java.util.*;
import java.util.stream.Stream;

public class FindElements {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 4, 5, 6);
        Optional<Integer> elements = list.stream().findFirst();
        if(elements.isPresent())
            System.out.println("element found: "+elements.get());
        else
            System.out.println("stream is empty");

        Optional<Integer> elements1 = list.stream().findAny();
        if(elements1.isPresent())
            System.out.println("element found: "+elements1.get());
        else
            System.out.println("stream is empty");

        //count min max
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8 ,9);
        System.out.println("stream count: " + stream.count());

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8 ,9);
        Integer integer  = stream1.min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Min: " + integer);

        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8 ,9);
        Integer integer1  = stream2.max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Max: " + integer1);
    }
}
