package com.unique.hrms.service;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.unique.hrms.model.User;

public interface UserService {
	public Optional<User> finduserBystrEmail(String email);
	
	public Optional<User> finduserBystrRestToken(String token);

	void save(User user);
	
	public User findByuserName(String userName);
	
	
	
}
