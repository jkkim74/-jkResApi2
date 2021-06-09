package com.example.springApiTest.demo.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test10 {

    public static void main(String[] args){
        List<OnLineClass> springClasses = new ArrayList<>();
        springClasses.add(OnLineClass.builder().id("1").title("spring boot").closed(true).build());
        springClasses.add(OnLineClass.builder().id("2").title("spring data jpa").closed(true).build());
        springClasses.add(OnLineClass.builder().id("3").title("spring mvc").closed(false).build());
        springClasses.add(OnLineClass.builder().id("4").title("spring core").closed(false).build());
        springClasses.add(OnLineClass.builder().id("5").title("rest api development").closed(false).build());

        System.out.println("spring으로 시작하는 수업");

        springClasses.stream().filter(s -> s.getTitle().startsWith("spring"))
                .forEach(s -> System.out.println(s));

        System.out.println("close 되지 않은 수업");
        springClasses.stream().filter(Predicate.not(OnLineClass::isClosed))
                .forEach(s -> System.out.println(s));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream().map(s -> s.getTitle())
                .forEach(System.out::println);

        List<OnLineClass> javaClasses = new ArrayList<>();
        javaClasses.add(OnLineClass.builder().id("6").title("The Java Test").closed(true).build());
        javaClasses.add(OnLineClass.builder().id("7").title("The Java Code manupulation").closed(true).build());
        javaClasses.add(OnLineClass.builder().id("8").title("The Java 8 to 11").closed(false).build());

        List<List<OnLineClass>> jkkimEvents = new ArrayList<>();
        jkkimEvents.add(springClasses);
        jkkimEvents.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        jkkimEvents.stream().flatMap(Collection::stream)
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개를 빼고 최대 10개까지만");
        Stream.iterate(10,i-> i+1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업중에 Test가 있는 수업이 있는지 확인");

        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);



    }
}
