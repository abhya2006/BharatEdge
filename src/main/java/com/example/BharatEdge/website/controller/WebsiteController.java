package com.example.BharatEdge.website.controller;

import com.example.BharatEdge.website.DTO.WebsiteDto;
import com.example.BharatEdge.website.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebsiteController {

    @Autowired
    WebService webService;

    @PostMapping("/webRegister")
    public ResponseEntity<String> saveWebsite(@RequestBody WebsiteDto webdto){
       String response= webService.save(webdto);
       return ResponseEntity.ok(response);


    }
}
