package com.example.springApiTest.demo.common;

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args){
        String[] aa = {"keesun","jaeki","eunhye"};
        Arrays.sort(aa, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(aa));
    }
}
