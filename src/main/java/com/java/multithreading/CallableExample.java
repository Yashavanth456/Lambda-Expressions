package com.java.multithreading;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<String> callableTask = () -> {
            Thread.sleep(1000);
            return "Task completed";
        };

        Future<String> future = executor.submit(callableTask);

        // Do other things...

        // Get the result (blocking call)
        String result = future.get();
        System.out.println(result);  // Output: Task completed

        executor.shutdown();
    }
}

