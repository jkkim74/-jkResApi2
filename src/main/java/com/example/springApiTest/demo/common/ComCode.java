package com.example.springApiTest.demo.common;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ComCode {
    String codeId;
    String codeValue;
    String codeType;


}
