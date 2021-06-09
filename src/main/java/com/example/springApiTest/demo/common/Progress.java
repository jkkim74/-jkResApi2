package com.example.springApiTest.demo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;

@Setter
@Getter
@Builder
@AllArgsConstructor
public class Progress {
    private String status;
}
