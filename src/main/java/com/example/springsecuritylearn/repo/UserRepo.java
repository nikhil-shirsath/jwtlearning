package com.example.springsecuritylearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springsecuritylearn.Entity.User;

public interface UserRepo extends JpaRepository<User,Long>{

}
