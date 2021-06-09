package com.example.springApiTest.demo.common;

import java.util.*;

public class App_Optional {
    public static void main(String[] args){
        List<OnLineClass> springClasses = new ArrayList<>();
        springClasses.add(OnLineClass.builder().id("1").title("Spring Jpa").closed(true).progress(new Progress("progressiong")).build());
        springClasses.add(OnLineClass.builder().id("2").title("Spring MVC").closed(true).progress(new Progress("progressiong")).build());
        springClasses.add(OnLineClass.builder().id("3").title("Spring Boot").closed(true).progress(new Progress("progressiong")).build());

        Optional<OnLineClass> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("Spring"))
                .findFirst();
        Optional<Progress> progress = spring.flatMap(OnLineClass::getProgress);
        Progress progress1 = progress.orElse(Progress.builder().status("start").build());
        System.out.println(progress1.getStatus());


    }

    private static OnLineClass createNewClass() {
        System.out.println("Creating new online Class");
        return new OnLineClass("10","New class",false, Progress.builder().status("processiong").build());
    }
}
