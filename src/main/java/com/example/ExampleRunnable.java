package com.example;

public class ExampleRunnable implements Runnable {

    private Long userId;

    private static ThreadLocal<Long> context
            = new ThreadLocal<>();

    public ExampleRunnable(Long userId) {
        this.userId = userId;
    }

    @Override
    public void run() {
        context.set(userId);
        System.out.println("Thread: " + Thread.currentThread().getName()
                + " User ID: " + context.get());
    }



}
