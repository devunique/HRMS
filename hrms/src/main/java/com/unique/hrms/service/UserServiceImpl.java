package com.unique.hrms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unique.hrms.model.User;
import com.unique.hrms.repository.UserRepository;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Optional<User> finduserBystrEmail(String email) {
		return userRepository.findBystrEmail(email);
	}

	@Override
	public Optional<User> finduserBystrRestToken(String token) {		
		return userRepository.findBystrResetToken(token);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public User findByuserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByuserName(userName) ;
	}
	
}
