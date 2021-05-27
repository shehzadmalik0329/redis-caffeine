package com.example.redis.caffeine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.redis.caffeine.entity.User;
import com.example.redis.caffeine.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Cacheable(key = "#id", value = "user")
	public User findUserById(Integer id){
		System.out.println("Fetching data from DB");
		return userRepository.findById(id).get();
	}
	
	public List<User> findAllUsers(){
		return userRepository.findAll();
	}
	
	public User saveUser(User user){
		userRepository.save(user);
		return user;
	}
	@CacheEvict(key = "#id", value = "user")
	public String deleteUserById(Integer id){
		System.out.println("Removing data from cache");
		userRepository.deleteById(id);
		return "User Deleted!!!";
	}

}
