package com.example.springApiTest.demo.common;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Foo {
    public static void main(String[] args){
        Foo foo = new Foo();
        foo.run();

    }

    private void run() {
        int basNumber = 10;
        class localClass{
            void printBaseNumber(){
                System.out.println(basNumber);
            }
        }
        Consumer<Integer> consumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(basNumber);
            }
        };
        IntConsumer consumer = (i) ->{
            System.out.println(i + basNumber);
        };

    }
}
