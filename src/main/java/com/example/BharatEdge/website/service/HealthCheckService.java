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

        Optional<Website> optionalWebsite =
                websiterepo.findById(id);

        if (optionalWebsite.isEmpty()) {
            return "Website Not Found";
        }

        Website website = optionalWebsite.get();

        try {

            long startTime = System.currentTimeMillis();

            RestTemplate restTemplate = new RestTemplate();

            ResponseEntity<String> response =
                    restTemplate.getForEntity(
                            website.getUrl(),
                            String.class
                    );

            long endTime = System.currentTimeMillis();

            long responseTime = endTime - startTime;

            int statusCode = response.getStatusCode().value();

            String status;

            if (statusCode >= 200 &&
                    statusCode < 400) {

                status = "UP";

            } else {

                status = "DOWN";
            }

            return
                    "Website : " + website.getName() +
                            "\nStatus : " + status +
                            "\nStatus Code : " + statusCode +
                            "\nResponse Time : " + responseTime + " ms";


        }

        catch (Exception e) {

            return
                    "Website : " + website.getName() +
                            "\nStatus : DOWN";
        }
    }
}