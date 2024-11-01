package com.sp.main.service;

import java.util.List;
import java.util.Optional;

import com.sp.main.entities.User;

public interface UserService {
	
	public User createUser(User user);
	
	public List<User> getAllUser();
	
	public Optional<User> getUserById(int id);
	
	public User updateUser(int id , User user);
	
	public void deleteUser(int id);
	

}
