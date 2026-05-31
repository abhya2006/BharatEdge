package com.example.BharatEdge.website.service;

import com.example.BharatEdge.user.entity.User;
import com.example.BharatEdge.user.repository.Repo;
import com.example.BharatEdge.website.DTO.WebsiteDto;
import com.example.BharatEdge.website.Repo.Websiterepo;
import com.example.BharatEdge.website.entity.Website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebService {

    @Autowired
    private Websiterepo websiterepo;

    @Autowired
    private Repo repo;

    public String save(WebsiteDto webdto) {

        User user = repo.findById(webdto.getUserId())
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Website website = new Website();

        website.setName(webdto.getName());
        website.setUrl(webdto.getUrl());
        website.setStatus("ACTIVE");

        website.setUser(user);

        websiterepo.save(website);

        return "Website Saved Successfully";
    }
}