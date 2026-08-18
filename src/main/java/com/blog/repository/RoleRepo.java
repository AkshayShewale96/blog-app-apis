package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Entity.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
