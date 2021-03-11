package com.example.springApiTest.demo;


import com.example.springApiTest.demo.events.Event;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EventTest {

    @Test
    public void testFree(){
        // Given
        Event event = Event.builder()
                .basePrice(0)
                .maxPrice(0)
                .build();
        // When
        event.update();

        // Then
        assertThat(event.isFree()).isTrue();

        // Given
        event = Event.builder()
                .basePrice(100)
                .maxPrice(0)
                .build();
        // When
        event.update();

        // Then
        assertThat(event.isFree()).isFalse();

        // Given
        event = Event.builder()
                .basePrice(0)
                .maxPrice(100)
                .build();
        // When
        event.update();

        // Then
        assertThat(event.isFree()).isFalse();
    }


    @Test
    public void testOffline(){
        //Given
        Event event = Event.builder()
                .location("강남역 네이버 D2")
                .build();

        //When
        event.update();
        //Then
        assertThat(event.isOffline()).isTrue();

        //Given
        event = Event.builder()
                .location("")
                .build();

        //When
        event.update();
        //Then
        assertThat(event.isOffline()).isFalse();



    }
}
