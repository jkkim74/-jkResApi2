package com.example.springApiTest.demo.common;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class App_CompletableFuture2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() ->{
            System.out.println("Hello "+Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> future = hello.thenCompose(App_CompletableFuture2::getWorld);
        System.out.println(future.get());
    }

    private static CompletableFuture<String> getWorld(String messsage) {
        return CompletableFuture.supplyAsync(() ->{
            System.out.println("World "+Thread.currentThread().getName());
            return messsage+ " World";
        });
    }
}
