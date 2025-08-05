package com.lamba;

import java.awt.*;

interface Shape {
    void draw();
}
//traditional way
class Rectangle implements Shape {
    @Override
    public void draw(){
     System.out.println("Rectangle");
 }
}
class Circle implements Shape {
    @Override
    public void draw(){
        System.out.println("Circle");
    }
}
public class LambdaExpression {
    public static void main(String[] args) {
        Shape rectangle = () -> System.out.println("Rectangle");
        rectangle.draw();
        Shape circle = () -> System.out.println("Circle");
        circle.draw();
        print(rectangle);
        print(() -> System.out.println("Square"));
    }
//passing lambda expression to the method
public static void print(Shape shape){
        shape.draw();;
}
}
