package com.sp.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.main.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	

}
