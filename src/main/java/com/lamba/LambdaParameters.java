package com.lamba;

interface Addable{
    int addition(int a, int b);
}

//traditional way
class AddableImpl implements  Addable{

    @Override
    public int addition(int a, int b) {
        return a + b;
    }
}
public class LambdaParameters {
    public static void main(String[] args) {
        Addable add = (a, b) -> (a + b);
       System.out.println(add.addition(2, 3));
        Addable sum = Integer::sum;
        System.out.println(sum.addition(6, 3));

        Addable addition = (int a, int b) -> {
            int c = a + b;
            return c;
        };
        System.out.println(addition.addition(10, 20));
    }

}
