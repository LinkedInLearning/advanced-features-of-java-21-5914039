package com.example;

public class ExampleRunnable implements Runnable {

    private String user;

    private static ScopedValue<String> userContext
            = ScopedValue.newInstance();

    public ExampleRunnable(String user) {
        this.user = user;
    }

    @Override
    public void run() {
        ScopedValue.where(userContext, user).run(
                () -> System.out.println("Thread: " + Thread.currentThread().getName()
                        + " User: " + userContext.get()));
    }



}
