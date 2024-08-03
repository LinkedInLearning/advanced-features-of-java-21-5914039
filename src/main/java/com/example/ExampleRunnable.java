package com.example;

public class ExampleRunnable implements Runnable {

    private String user;

    private static ThreadLocal<String> userContext
            = new ThreadLocal<>();

    public ExampleRunnable(String user) {
        this.user = user;
    }

    @Override
    public void run() {
        userContext.set(user);
        System.out.println("Thread: " + Thread.currentThread().getName()
                + " User: " + userContext.get());
    }



}
