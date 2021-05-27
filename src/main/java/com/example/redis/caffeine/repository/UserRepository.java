package com.example.redis.caffeine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.redis.caffeine.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
