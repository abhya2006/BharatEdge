package com.example.BharatEdge.website.controller;


import com.example.BharatEdge.website.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping("/check/{id}")
    public String checkWebsite(
            @PathVariable Long id) {

        return healthCheckService.checkWebsite(id);
    }
}