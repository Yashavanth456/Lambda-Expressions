package com.lamba;

@FunctionalInterface
public interface MyFunctionalInterface {
    void print(String msg);

    default void m1(){
        System.out.println("message from m1");
    }
    static void m2(){
        System.out.println("message from m2");
    }
}
