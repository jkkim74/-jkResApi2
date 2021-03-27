package com.example.springApiTest.demo.common;

public class FooIntImpl implements FooInt {

    String name;

    public FooIntImpl(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
