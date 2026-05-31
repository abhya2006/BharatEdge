package com.example.BharatEdge.website.service;

import com.example.BharatEdge.user.entity.User;
import com.example.BharatEdge.user.repository.Repo;
import com.example.BharatEdge.website.DTO.WebsiteDto;
import com.example.BharatEdge.website.Repo.Websiterepo;
import com.example.BharatEdge.website.entity.Website;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<Website> getAll(){
        return websiterepo.findAll();
    }


    public List<WebsiteDto> getAllWebsites() {

        List<Website> websites = websiterepo.findAll();

        List<WebsiteDto> dtoList = new ArrayList<>();

        for (Website website : websites) {

            WebsiteDto dto = new WebsiteDto();

            dto.setName(website.getName());
            dto.setUrl(website.getUrl());
            dto.setUserId(website.getUser().getId());

            dtoList.add(dto);
        }

        return dtoList;
    }

    public WebsiteDto getById(Long id){
        Website websites=websiterepo.getById(id);

        WebsiteDto dto=new WebsiteDto();
        dto.setName(websites.getName());
        dto.setUrl(websites.getUrl());
        dto.setUserId(websites.getUser().getId());


        return dto;
    }
    public String delete(Long id) {

        if (!websiterepo.existsById(id)) {
            return "Website Not Found";
        }
        websiterepo.deleteById(id);
        return "Website Deleted Successfully";
    }

}