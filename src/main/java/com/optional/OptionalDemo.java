package com.optional;

import java.sql.SQLOutput;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        //of, empty, ofNullable
        String email = "yashavanth@gmail.com";
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Optional<String> emailOptional = Optional.of(email);
        System.out.println(emailOptional);

        Optional<String> emailOptional1 = Optional.ofNullable(email);
        System.out.println(emailOptional1);

        if(emailOptional1.isPresent()){
            System.out.println(emailOptional1.get());
        }
        else{
            System.out.println("No value present");
        }

        String stringOrElse = emailOptional1.orElse("default@gmail.com");
        System.out.println(stringOrElse);

        String stringOrElseThrow = emailOptional1.orElseThrow(() -> new IllegalArgumentException("No email exist"));
        System.out.println(stringOrElseThrow);

        String result = " abc ";
        Optional<String> optionalString = Optional.of(result);
        optionalString.filter(res -> res.contains("abc"))
                .map(String::trim)
                .ifPresent(System.out::println);
    }
}
