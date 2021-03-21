package com.example.springApiTest.demo.common;

import java.util.function.Predicate;

public class TestJava81 {
    public static void main(String[] args){
        Predicate<String> startWithJk = (s) -> s.startsWith("jk");
        Predicate<String> startWithJk2 = (s) -> s.startsWith("jka");
        //Predicate<Integer> isEven = (i) -> i%2 == 0;
        //System.out.println(startWithJk.and(startWithJk2));

        Predicate<String> startWithJk3 = startWithJk.and(startWithJk2);
        System.out.println(startWithJk3.test("jkabc1234"));
    }
}
