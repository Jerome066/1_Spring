package com.spring1basic.practica1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring1basic.practica1.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    
}
