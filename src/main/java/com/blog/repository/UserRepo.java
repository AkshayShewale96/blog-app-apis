package com.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	// created for Security Email act as UserId to login.
	// used in CustomUserDetailService.Class
	Optional<User> findByEmail(String email);
}
