package com.example.wiremock.controller;

import com.example.wiremock.domain.WireMockResponse;
import com.example.wiremock.service.WireMockDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class WireMockDemoController {

    WireMockDemoService wiremockDemoService;

    @Autowired
    public WireMockDemoController(WireMockDemoService wiremockDemoService) {
        this.wiremockDemoService = wiremockDemoService;
    }

    @GetMapping
    @RequestMapping("/getMessage")
    public WireMockResponse getMessage() {
        return this.wiremockDemoService.getMessage();
    }

}
