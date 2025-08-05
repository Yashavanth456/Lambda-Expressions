package com.streamapi;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {

        //creating stream
        Stream<String> stream = Stream.of("a", "b", "c");
        stream.forEach(System.out::println);

        //creating stream from collection
        Collection<String> collection = Arrays.asList("Java", "C", "C++");
        Stream<String> stream1 = collection.stream();
        stream1.forEach(System.out::println);

        String[] strArray = {"a", "b", "c"};
        Stream<String> stream2 = Arrays.stream(strArray);
        stream2.forEach(System.out::println);
    }
}
