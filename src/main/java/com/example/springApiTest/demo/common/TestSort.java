package com.example.springApiTest.demo.common;

import java.util.*;

public class TestSort {

    public static void main(String[] args) throws Exception{
        List<Map<String,String>> subList = new ArrayList<>();
        Map<String,String> baner1 = new HashMap<>();
        baner1.put("title","TEST1");
        baner1.put("rtdOnlyYn","N");
        baner1.put("priority","0");
        subList.add(baner1);

        Map<String,String> baner2 = new HashMap<>();
        baner2.put("title","TEST2");
        baner2.put("rtdOnlyYn","B");
        baner2.put("priority","0");
        subList.add(baner2);

        Map<String,String> baner3 = new HashMap<>();
        baner3.put("title","TEST3");
        baner3.put("rtdOnlyYn","M3");
        baner3.put("priority","0");
        subList.add(baner3);

        Map<String,String> baner4 = new HashMap<>();
        baner4.put("title","TEST4");
        baner4.put("rtdOnlyYn","N");
        baner4.put("priority","1");
        subList.add(baner4);

        Map<String,String> baner5 = new HashMap<>();
        baner5.put("title","TEST5");
        baner5.put("rtdOnlyYn","M4");
        baner5.put("priority","0");
        subList.add(baner5);

        Map<String,String> baner6 = new HashMap<>();
        baner6.put("title","TEST6");
        baner6.put("rtdOnlyYn","M5");
        baner6.put("priority","0");
        subList.add(baner6);

        Map<String,String> baner7 = new HashMap<>();
        baner7.put("title","TEST7");
        baner7.put("rtdOnlyYn","M6");
        baner7.put("priority","0");
        subList.add(baner7);

        Map<String,String> baner8 = new HashMap<>();
        baner8.put("title","TEST8");
        baner8.put("rtdOnlyYn","F");
        baner8.put("priority","0");
        subList.add(baner8);

        Collections.sort(subList, new Comparator<Map<String,String>>() {

            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                int result = o1.get("rtdOnlyYn").compareTo(o2.get("rtdOnlyYn"));
                System.out.println(o1.get("rtdOnlyYn")+":"+o2.get("rtdOnlyYn")+"===>"+result);
                if(result == 0){
                    result = o1.get("priority").compareTo(o2.get("priority")) * -1;
                }
                return result;
            }
        });

        for (Map<String,String> baner : subList) {
            System.out.println(baner);
        }


    }
}
