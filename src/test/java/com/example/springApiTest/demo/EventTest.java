package com.example.springApiTest.demo;


import com.example.springApiTest.demo.events.Event;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(JUnitParamsRunner.class)
public class EventTest {

    @Test
    @Parameters
    public void testFree(int basePrice, int maxPrice, boolean isFree){
        // Given
        Event event = Event.builder()
                .basePrice(basePrice)
                .maxPrice(maxPrice)
                .build();
        // When
        event.update();

        // Then
        assertThat(event.isFree()).isEqualTo(isFree);


    }

    private Object[] parametersForTestFree(){
        return new Object[]{
                new Object[]{0,0,true},
                new Object[]{100,0,false},
                new Object[]{0,100,false},
                new Object[]{100,100,false}
        };
    }


    @Test
    @Parameters
    public void testOffline(String location, boolean isOffLine){
        //Given
        Event event = Event.builder()
                .location(location)
                .build();

        //When
        event.update();
        //Then
        assertThat(event.isOffline()).isEqualTo(isOffLine);
    }

    private Object[] parametersForTestOffline(){
        return new Object[]{
                new Object[]{"강남",true},
                new Object[]{null,false},
                new Object[]{"      ",false}
        };
    }
}
