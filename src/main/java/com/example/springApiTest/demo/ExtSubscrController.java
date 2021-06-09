package com.example.springApiTest.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/extSubscr")
public class ExtSubscrController {
    private String filePath = "exsubscr/";
    @GetMapping("/prdInfo")
    public String subscrPrdInfo(@RequestParam(name="joinUrl",required = false) String joinUrl){
        return filePath + "prdInfo";
    }
}
