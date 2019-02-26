package com.unique.hrms.service;

import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.unique.hrms.model.User;
import com.unique.hrms.model.UserLogin;

public interface UserService {
	public Optional<UserLogin> finduserBystrLoginId(String email);
	
	public Optional<UserLogin> finduserBystrRestToken(String token);

	void save(UserLogin UserLogin);
	
	public UserLogin findByuserName(String userName);
	
//	public void updatePass(String password,String strloginId);
	
	
}
