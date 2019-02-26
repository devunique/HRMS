package com.unique.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.unique.hrms.model.UserLogin;

@Repository("userRepository")
public interface UserRepository extends JpaRepository <UserLogin, Long>{
	
	Optional<UserLogin> findBystrLoginId(String email);
	Optional<UserLogin> findBystrResetToken(String resetToken);
	
	@Query("select u from UserLogin u where u.strLoginId=?1")
	UserLogin findByuserName(String userName);
	/*@Modifying
	@Query("update  Userlogin u set u.strPassword=?1 where u.strLoginId=?2")
	void updatePassword(String password,String strLoginId);*/
}
