package com.unique.hrms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unique.hrms.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository <User, Long>{
	
	Optional<User> findBystrEmail(String email);
	Optional<User> findBystrResetToken(String resetToken);
	
	@Query("select u from User u where u.userName=?1")
	User findByuserName(String userName);
}
