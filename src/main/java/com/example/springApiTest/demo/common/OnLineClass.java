package com.example.springApiTest.demo.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Optional;

@Setter
@Getter
@Builder
@ToString
public class OnLineClass {
    private String id;
    private String title;
    private boolean closed;
    private Progress progress;

    public Optional<Progress> getProgress(){
        return Optional.of(progress);
    }

}
