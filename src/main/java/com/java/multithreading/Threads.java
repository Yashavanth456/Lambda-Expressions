package com.java.multithreading;


class Threads{
    public static void main(String[] args) {
            MyThread t = new MyThread();
            t.start(); // starts the thread and calls run()

        Thread tr = new Thread(new MyRunnable());
        tr.start();
        }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread running");
    }
}