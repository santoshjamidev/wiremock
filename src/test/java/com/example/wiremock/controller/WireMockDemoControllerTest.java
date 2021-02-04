package com.example.wiremock.controller;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class WireMockDemoControllerTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(9999).httpsPort(8889));

    @Autowired
    private MockMvc mvc;

    String URI = null;

    @Autowired
    WireMockDemoController wireMockDemoController;


    @Before
    public void setUp() {
        URI = "/demo/getMessage";
    }

    @Test
    public void testGetMessage() throws Exception {

        mvc.perform(get(URI)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{'message': 'Hello With Params'}"));

    }
}

