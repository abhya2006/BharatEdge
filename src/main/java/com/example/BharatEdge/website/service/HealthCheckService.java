package com.example.BharatEdge.website.service;

import com.example.BharatEdge.website.Repo.Websiterepo;
import com.example.BharatEdge.website.entity.Website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class HealthCheckService {

    @Autowired
    private Websiterepo websiterepo;

    public String checkWebsite(Long id) {

        Optional<Website> Website =
                websiterepo.findById(id);

        if (Website.isEmpty()) {
            return "Website Not Found";
        }

        Website website = Website.get();

        try {

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response =
                    restTemplate.getForEntity(
                            website.getUrl(),
                            String.class
                    );

            return response.getStatusCode().toString();

        } catch (Exception e) {

            return "Website Down";
        }
    }
}