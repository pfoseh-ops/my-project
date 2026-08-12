package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StatusController.class)
class StatusControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void statusEndpointReturnsApplicationStatus() throws Exception {
        mockMvc.perform(get("/status"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.application").value("java-app"))
            .andExpect(jsonPath("$.status").value("OK"));
    }

    @Test
    void rootEndpointReturnsProfilePage() throws Exception {
        mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
            .andExpect(content().string(org.hamcrest.Matchers.containsString(
                "<h1>Paul Foseh</h1>")))
            .andExpect(content().string(org.hamcrest.Matchers.containsString(
                "<p>Senior DevOps, Cloud, SRE &amp; DevSecOps Engineer")));
    }
}
