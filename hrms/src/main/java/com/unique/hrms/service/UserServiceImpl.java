package com.unique.hrms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unique.hrms.model.User;
import com.unique.hrms.model.UserLogin;
import com.unique.hrms.repository.UserRepository;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<UserLogin> finduserBystrLoginId(String email) {
		// TODO Auto-generated method stub
		return userRepository.findBystrLoginId(email);
	}

	@Override
	public Optional<UserLogin> finduserBystrRestToken(String token) {
		// TODO Auto-generated method stub
		return userRepository.findBystrResetToken(token);
	}

	@Override
	public void save(UserLogin UserLogin) {
		// TODO Auto-generated method stub
		userRepository.save(UserLogin);
	}

	@Override
	public UserLogin findByuserName(String userName) {
		// TODO Auto-generated method stub
		return userRepository.findByuserName(userName);
	}

	/*@Override
	public void updatePass(String password, String strloginId) {
		// TODO Auto-generated method stub
		userRepository.updatePassword(password, strloginId);
	}*/
	
	/*@Override
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
	*/
}
