package com.example.BharatEdge.user.repository;

import com.example.BharatEdge.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repo extends JpaRepository<Long, User> {
    public boolean findByUserName(String userName);
}
