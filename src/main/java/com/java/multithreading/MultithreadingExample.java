package com.java.multithreading;

public class MultithreadingExample {
    public static void main(String[] args) {
        // Create two Runnable tasks
        Runnable task1 = new MyRunnable2("Thread-1");
        Runnable task2 = new MyRunnable2("Thread-2");

        // Create Thread objects to run the tasks concurrently
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        // Start the threads (this invokes run() in separate threads)
        thread1.start();
        thread2.start();

        System.out.println("Main thread finished.");
    }
}

// Define a class that implements Runnable to define the task
class MyRunnable2 implements Runnable {
    private String threadName;

    MyRunnable2(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        // Code that runs in the new thread
        for (int i = 0; i < 5; i++) {
            System.out.println(threadName + " is running, count: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second to simulate work
            } catch (InterruptedException e) {
                System.out.println(threadName + " interrupted.");
            }
        }
        System.out.println(threadName + " finished execution.");
    }
}

