package com.sp.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.main.entities.User;
import com.sp.main.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo repo;

	
	public User createUser(User user) {
		
		repo.save(user);
		return user;
	}


	@Override
	public List<User> getAllUser() {
	
		return repo.findAll();
		
		
	}


	@Override
	public Optional<User> getUserById(int id) {
		
		return repo.findById(id);
	
	}


	@Override
	public User updateUser(int id, User newUser) {
		
		User userData = repo.findById(id).orElse(null);
		
		if(userData!= null) {
			
		   return repo.save(newUser);
		}
		
		else {
			
			throw new RuntimeException("User not found with id" + id);
		}
	}


	@Override
	public void deleteUser(int id) {
		
		 repo.deleteById(id);
		
		
	}

	
}
