package com.example.BharatEdge.Authentication.forget;

import com.example.BharatEdge.user.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForgetController {
    @Autowired
    ForgetService service;

    @PostMapping("/forget")
    public ResponseEntity<String> forgetPassword(@RequestBody ForgetDTO fDTO){
        String response=service.resetPassword(fDTO);
        return ResponseEntity.ok(response);
    }
}
