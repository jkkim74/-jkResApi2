package com.example.springApiTest.demo.common;

import java.util.function.*;

public class TestJava8 {

    public static void main(String[] args) throws Exception{
//        UnaryOperator<Integer> plus = (number ) -> number + 10;
//        //System.out.println(plus.apply(10));
//        UnaryOperator<Integer> multipl1 = ( number ) -> number * 2;
//
//        Function<Integer,Integer> plusCompMulti = plus.compose(multipl1);
//        System.out.println(plusCompMulti.apply(2));
//
//        System.out.println(plus.andThen(multipl1).apply(3));

        BinaryOperator<Integer> sum = (a,b) -> a + b;

        BiConsumer<Integer,Integer> consumer = (i,i2) -> System.out.println(i+i2);
        consumer.accept(10,15);
        BiFunction<Integer,Integer,Integer> biFunction = (num1,num2) -> num1 + num2;
        System.out.println(biFunction.apply(10,20));

        BiPredicate<Integer,Integer> biPredicate = (num1,num2) -> num1 > num2;
        System.out.println(biPredicate.test(100,90));

        BinaryOperator<Integer> binaryOperator = (num1,num2) -> num1 * num2;
        System.out.println(binaryOperator.apply(100,35));
    };
}
