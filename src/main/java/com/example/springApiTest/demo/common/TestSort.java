package com.example.springApiTest.demo.common;

import net.minidev.json.JSONObject;

import java.util.*;
import java.util.stream.Collectors;

public class TestSort {

    public static void main(String[] args) throws Exception{
        List<Map<String,String>> subList = new ArrayList<>();
        Map<String,String> baner1 = new HashMap<>();
        baner1.put("title","TEST1");
        baner1.put("rtdOnlyYn","N");
        baner1.put("priority","0");
        subList.add(baner1);

        Map<String,String> baner4 = new HashMap<>();
        baner4.put("title","TEST4");
        baner4.put("rtdOnlyYn","N");
        baner4.put("priority","1");
        subList.add(baner4);

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

        Map<String,String> baner5 = new HashMap<>();
        baner5.put("title","TEST5");
        baner5.put("rtdOnlyYn","M4");
        baner5.put("priority","1");
        subList.add(baner5);

        Map<String,String> baner6 = new HashMap<>();
        baner6.put("title","TEST6");
        baner6.put("rtdOnlyYn","M5");
        baner6.put("priority","2");
        subList.add(baner6);

        Map<String,String> baner7 = new HashMap<>();
        baner7.put("title","TEST7");
        baner7.put("rtdOnlyYn","M6");
        baner7.put("priority","3");
        subList.add(baner7);

        Map<String,String> baner8 = new HashMap<>();
        baner8.put("title","TEST8");
        baner8.put("rtdOnlyYn","F");
        baner8.put("priority","0");
        subList.add(baner8);
        //String orderedRtd = "{\"B:0\",\"F:1\",\"M:2\",\"N:3\"}";
        try {
            JSONObject orderConf = new JSONObject();
            orderConf.put("B", 1);
            orderConf.put("F", 2);
            orderConf.put("M", 0);

            List<ComCode> codeList = new ArrayList<>();
            ComCode code = ComCode.builder().codeId("BIRTHDAY").codeValue("B").codeType("0").build();
            ComCode code1 = ComCode.builder().codeId("FOREIGNER").codeValue("F").codeType("1").build();
            ComCode code2 = ComCode.builder().codeId("VIP_PLUS_M3").codeValue("M3").codeType("2").build();
            ComCode code3 = ComCode.builder().codeId("VIP_PLUS_M4").codeValue("M4").codeType("3").build();
            ComCode code4 = ComCode.builder().codeId("VIP_PLUS_M5").codeValue("M5").codeType("4").build();
            ComCode code5 = ComCode.builder().codeId("VIP_PLUS_M6").codeValue("M6").codeType("5").build();
            ComCode code6 = ComCode.builder().codeId("VIP_PLUS_M6").codeValue("M6").codeType("6").build();
            codeList.add(code);
            codeList.add(code1);
            codeList.add(code2);
            codeList.add(code3);
            codeList.add(code4);
            codeList.add(code5);
            codeList.add(code6);
            Map<String,Object> priBanCodeMap = codeList.stream().collect(Collectors.toMap(a -> a.getCodeValue(), b -> b.getCodeType()));
            //orderConf.put("N",3);
            // 공통코드를 가져와서 거기에 정렬순위 정보를 타입에 넣어서 그값으로 정렬정보를 가져와
            // 아래와 같이 정렬을 한다.
            Collections.sort(subList, (o1, o2) -> {
                Integer order1 = (Integer) priBanCodeMap.getOrDefault(o1.getOrDefault("rtdOnlyYn", "N"), 10);
                Integer order2 = (Integer) priBanCodeMap.getOrDefault(o2.getOrDefault("rtdOnlyYn", "N"), 10);
                int result = order1.compareTo(order2);
                System.out.println(o1.get("rtdOnlyYn") + ":" + o2.get("rtdOnlyYn") + "===>" + result);
                return result;
            });
        }catch(IllegalArgumentException ie){
            System.out.println("Sorting IllegalArgumentException Happend");
        }catch(Exception e){
            System.out.println("Sorting Exception Happend");
        }

        for (Map<String,String> baner : subList) {
            System.out.println(baner);
        }


    }
}
