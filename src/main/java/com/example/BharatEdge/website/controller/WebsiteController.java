package com.example.BharatEdge.website.controller;

import com.example.BharatEdge.website.DTO.WebsiteDto;
import com.example.BharatEdge.website.entity.Website;
import com.example.BharatEdge.website.service.WebService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebsiteController {

    @Autowired
    WebService webService;

    @PostMapping("/webRegister")
    public ResponseEntity<String> saveWebsite(@RequestBody WebsiteDto webdto){
       String response= webService.save(webdto);
       return ResponseEntity.ok(response);
    }
    @GetMapping("/all")
    public ResponseEntity<List<WebsiteDto>> getAllWebsites() {
        return ResponseEntity.ok(webService.getAllWebsites());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WebsiteDto> getById(@PathVariable Long id){
        return ResponseEntity.ok(webService.getById(id));
    }
}
