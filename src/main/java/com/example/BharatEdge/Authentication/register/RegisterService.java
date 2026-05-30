package com.example.BharatEdge.Authentication.register;

import com.example.BharatEdge.user.entity.User;
import com.example.BharatEdge.user.repository.Repo;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    private final Repo repo;

    public RegisterService(Repo repo) {
        this.repo = repo;
    }

    public void register(RegisterDTO dto){
        User user=new User();
        user.setUserName(dto.getUserName());
        user.setEmai(dto.getEmai());
        user.setPassword(dto.getPassword());
        user.setNumber(dto.getNumber());
        repo.save(user);
    }
}
