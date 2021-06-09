package com.example.springApiTest.demo.common;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OnLineClass {
    private Integer id;
    private String title;
    private boolean closed;
}
