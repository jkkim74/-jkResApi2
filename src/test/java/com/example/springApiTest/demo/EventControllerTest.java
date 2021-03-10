package com.example.springApiTest.demo;


import com.example.springApiTest.demo.common.TestDescription;
import com.example.springApiTest.demo.events.Event;
import com.example.springApiTest.demo.events.EventDto;
import com.example.springApiTest.demo.events.EventRepository;
import com.example.springApiTest.demo.events.EventStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EventControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @TestDescription("입력받은 값만 나오도록 하는 테스트")
    public void createEventTest() throws Exception {
        EventDto event = EventDto.builder()
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
        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON+";charset=utf-8")
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("id").exists())
                .andExpect(header().exists("location"))
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaTypes.HAL_JSON_VALUE+";charset=utf-8"))
                .andExpect(jsonPath("id").value(Matchers.not(100)))
                .andExpect(jsonPath("free").value(Matchers.not(true)))
                .andExpect(jsonPath("eventStatus").value(Matchers.is("DRAFT")));
    }


    @Test
    public void createEventTest_Bad_Request() throws Exception {
        Event event = Event.builder()
                .id(100)
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
                .free(true)
                .offline(false)
                .eventStatus(EventStatus.PUBLISHED)
                .build();

        mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON+";charset=utf-8")
                .accept(MediaTypes.HAL_JSON)
                .content(objectMapper.writeValueAsString(event)))
                .andDo(print())
                .andExpect(status().isBadRequest())
        ;
    }


    @Test
    @TestDescription("입력값이 빈경우, 배드리퀘스트 테스트")
    public void createEvent_Bad_Request_Empty() throws Exception {
        EventDto eventDto = EventDto.builder()
                .build();

        this.mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(eventDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
    
    @Test
    @TestDescription("입력값이 잘못된 항목에 대한 테스트")
    public void createEvent_Bad_Request_Empty_Input() throws Exception {
        EventDto eventDto = EventDto.builder()
                .name("Spring")
                .description("REST Api Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2021, 03, 01, 13, 00))
                .closeEnrollmentDateTime(LocalDateTime.of(2021, 03, 05, 23, 59))
                .beginEventDateTime(LocalDateTime.of(2021, 03, 06, 00, 01))
                .endEventDateTime(LocalDateTime.of(2021, 03, 05, 23, 59))
                .basePrice(100)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타팀 팩토리")
                .build();

        this.mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(eventDto)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @TestDescription("입력값이 잘못된 항목에 대한 테스트")
    public void createEvent_Bad_Request_Wrong_Input() throws Exception {
        EventDto eventDto = EventDto.builder()
                .name("Spring")
                .description("REST Api Development with Spring")
                .beginEnrollmentDateTime(LocalDateTime.of(2021, 03, 01, 13, 00))
                .closeEnrollmentDateTime(LocalDateTime.of(2021, 03, 05, 23, 59))
                .beginEventDateTime(LocalDateTime.of(2021, 03, 06, 00, 01))
                .endEventDateTime(LocalDateTime.of(2021, 03, 05, 23, 59))
                .basePrice(10000)
                .maxPrice(200)
                .limitOfEnrollment(100)
                .location("강남역 D2 스타팀 팩토리")
                .build();

        this.mockMvc.perform(post("/api/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(eventDto)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[0].objectName").exists())
                .andExpect(jsonPath("$[0].field").exists())
                .andExpect(jsonPath("$[0].defaultMessage").exists())
                .andExpect(jsonPath("$[0].code").exists())
                .andExpect(jsonPath("$[0].rejectedValue").exists());

    }





}
