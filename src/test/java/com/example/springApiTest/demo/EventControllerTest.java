package com.example.springApiTest.demo;


import com.example.springApiTest.demo.events.Event;
import com.example.springApiTest.demo.events.EventRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest
public class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    EventRepository eventRepository;

    @Autowired
    private WebApplicationContext wac;

    @Test
    public void createEventTest() throws Exception {
        Event event = Event.builder()
                .name("Spring")
                .description("REST Api Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2021, 03, 01, 13, 00))
                .closeEnrollmentDateTime(LocalDateTime.of(2021, 03, 05, 23, 59))
                .beginEventDateTime(LocalDateTime.of(2021, 03, 6, 00, 01))
                .endEventDateTime(LocalDateTime.of(2021, 03, 9, 23, 59))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타팀 팩토리")
                .build();
        event.setId(10);
        Mockito.when(eventRepository.save(event)).thenReturn(event);
        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON+";charset=utf-8")
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").exists())
                .andExpect(header().exists("location"))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE+";charset=utf-8"));
    }

}
