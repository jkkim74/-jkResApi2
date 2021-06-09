package com.example.springApiTest.demo.common;

public class App_concurrent {

    public static void main(String[] args){
        Thread thread = new Thread (() -> {
            try {
                Thread.sleep(1000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread : "+ Thread.currentThread().getName());
        });
        thread.start();

        System.out.println("Hello : "+Thread.currentThread().getName());
    }
}
