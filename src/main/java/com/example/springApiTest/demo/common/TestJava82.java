package com.example.springApiTest.demo.common;

import java.util.function.*;

public class TestJava82 {
    public static void main(String[] args){
//        Greeting greeting = new Greeting();
//        UnaryOperator<String> hi = greeting::hello;
//        System.out.println(hi.apply("jae ki"));
        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting greeting = newGreeting.get();
        System.out.println(greeting.hello(" jkkim"));

        Function<String, Greeting> jkkimGreeting = Greeting::new;
        Greeting greeting1 =jkkimGreeting.apply("jkkim");
        System.out.println(greeting1.getName());
    }
}
