package com.example.redis.caffeine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.caffeine.entity.User;
import com.example.redis.caffeine.service.UserService;

@RestController
@RequestMapping
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/{id}")
	public User findUserById(@PathVariable Integer id){
		return userService.findUserById(id);
	}
	
	@GetMapping
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	
	@PostMapping
	public User saveUser(@RequestBody User user){
		return userService.saveUser(user);
	}
	
	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable Integer id){
		return userService.deleteUserById(id);
	}
}
