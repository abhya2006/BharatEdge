package com.example.BharatEdge.user.repository;

import com.example.BharatEdge.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String userName);
}
