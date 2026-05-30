package com.example.BharatEdge.Authentication.forget;

import com.example.BharatEdge.user.entity.User;
import com.example.BharatEdge.user.repository.Repo;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ForgetService {
    @Autowired
    Repo repo;
    public String resetPassword(ForgetDTO dto){
        Optional<User> user= repo.findByUserName(dto.getUserName());
        if (user.isPresent()){
            User user1=user.get();
            user1.setPassword(dto.getNewPassword());
            repo.save(user1);
            return "password updated";
        }
        return "user not found";
    }
}
