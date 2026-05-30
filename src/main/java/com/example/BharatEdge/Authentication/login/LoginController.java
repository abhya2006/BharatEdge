package com.example.BharatEdge.Authentication.login;

import com.example.BharatEdge.user.entity.User;
import com.example.BharatEdge.user.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    Repo userRepository;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto request) {

        Optional<User> user =
                userRepository.findByUserName(request.getUserName());

        if (user.isPresent()
                && user.get().getPassword().equals(request.getPassword())) {

            return ResponseEntity.ok("Login Successful");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid Username or Password");
    }
}
