package com.example.redis.caffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RedisCaffeineApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisCaffeineApplication.class, args);
	}

}
