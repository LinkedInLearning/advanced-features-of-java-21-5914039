package com.example;

public class Main {

    public static void main(String[] args) {
        var exampleRunnable1 = new ExampleRunnable("User 1");
        var thread1 = new Thread(exampleRunnable1);
        var exampleRunnable2 = new ExampleRunnable("User 2");
        var thread2 = new Thread(exampleRunnable2);
        thread1.start();
        thread2.start();
    }

}
