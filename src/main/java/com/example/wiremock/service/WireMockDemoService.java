package com.example.wiremock.service;

import com.example.wiremock.domain.WireMockResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WireMockDemoService {

    @Value("${recorder.url}")
    private String recorderUrl;

    public WireMockResponse getMessage() {

        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject("http://example.mocklab.io/recordables/123", WireMockResponse.class);

//        WireMockResponse result = restTemplate.getForObject("http://localhost:9999/hello/get?name=santosh", WireMockResponse.class);

        WireMockResponse result = restTemplate.getForObject(recorderUrl, WireMockResponse.class);
        return result;
    }
}
