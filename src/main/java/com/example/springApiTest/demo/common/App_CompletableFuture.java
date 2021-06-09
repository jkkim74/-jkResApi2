package com.example.springApiTest.demo.common;

import java.util.Locale;
import java.util.concurrent.*;

public class App_CompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);


        CompletableFuture<Void> future = CompletableFuture.supplyAsync(()->{
            System.out.println("Hello : "+Thread.currentThread().getName());
            return "Hello";
        },executorService).thenRunAsync(() ->{
            System.out.println("Hello thenapply : "+Thread.currentThread().getName());
        });
        future.get();


    }
}
