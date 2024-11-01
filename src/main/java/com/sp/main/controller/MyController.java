package com.sp.main.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sp.main.entities.User;
import com.sp.main.service.UserService;


@RestController
public class MyController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public String addUserDetails(@RequestBody User user) {
		
		service.createUser(user);
		
		return "created";
	}
	
	@GetMapping("/user")
	public List<User> getAllUser() {
		
		return service.getAllUser();
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id) {
		
		 User user = service.getUserById(id).orElse(null);
		 
		 if(user != null){
			 
			return ResponseEntity.ok().body(user);
		 }
		 
		 else {
			 
			 return ResponseEntity.notFound().build();
			 
		 }
		  
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUserDetails(@PathVariable int id , @RequestBody User user) {
		
		
		User updateUser = service.updateUser(id, user);
		
		if(user != null) {
			
			return ResponseEntity.ok(updateUser);
		}
		else {
			
			return ResponseEntity.notFound().build();
			
		}
		
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		
		service.deleteUser(id);
		return ResponseEntity.noContent().build();
		
	}
	

}
