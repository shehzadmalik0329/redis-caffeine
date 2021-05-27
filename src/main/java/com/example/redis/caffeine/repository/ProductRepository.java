package com.example.redis.caffeine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.redis.caffeine.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
