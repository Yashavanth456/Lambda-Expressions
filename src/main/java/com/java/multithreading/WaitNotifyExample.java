package com.java.multithreading;

class Message {
    private String message;
    private boolean empty = true;

    // Producer puts message, waits if previous not consumed
    public synchronized void put(String message) {
        while (!empty) {
            try {
                wait();  // Wait until the message is consumed
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        empty = false;
        this.message = message;
        System.out.println("Produced: " + message);
        notify();  // Notify consumer that message is available
    }

    // Consumer gets message, waits if no message available
    public synchronized String get() {
        while (empty) {
            try {
                wait();  // Wait until a message is produced
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        empty = true;
        System.out.println("Consumed: " + message);
        notify();  // Notify producer that message has been consumed
        return message;
    }
}

class Producer implements Runnable {
    private Message message;

    Producer(Message message) {
        this.message = message;
    }

    public void run() {
        String[] messages = {"Message 1", "Message 2", "Message 3", "DONE"};
        for (String msg : messages) {
            message.put(msg);  // Produce message
            try {
                Thread.sleep(500);  // Simulate time to produce
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer implements Runnable {
    private Message message;

    Consumer(Message message) {
        this.message = message;
    }

    public void run() {
        String msg = "";
        while (!msg.equals("DONE")) {
            msg = message.get();  // Consume message
            try {
                Thread.sleep(800);  // Simulate time to consume
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

public class WaitNotifyExample {
    public static void main(String[] args) {
        Message message = new Message();
        Thread producerThread = new Thread(new Producer(message));
        Thread consumerThread = new Thread(new Consumer(message));

        producerThread.start();
        consumerThread.start();
    }
}

