package com.lamba;

//traditional way
class ThreadDemo implements Runnable{

    @Override
    public void run() {
        System.out.println("run method called");
    }
}
public class RunnableLambdaExample {
    public static void main(String[] args) {
        //traditional way
        Thread thread = new Thread(new ThreadDemo());
        thread.start();

        Runnable runnable = () -> System.out.println("run called using lambda");
        Thread threadLambda = new Thread(runnable);
        threadLambda.start();
        Thread threadLambda1= new Thread(() -> System.out.println("run called using lambda"));
        threadLambda1.start();
    }
}
