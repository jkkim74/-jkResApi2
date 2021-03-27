package com.example.springApiTest.demo.common;

import java.util.Locale;

public interface FooInt {
    void printName();
    
    default void defaultPrintUppercase(){
        System.out.println(getName().toUpperCase(Locale.ROOT));
    }

    String getName();
}
