package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.Entity.Category;
import com.blog.Entity.Post;
import com.blog.Entity.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	// custom finder method.
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	// method for search
	List<Post> findByTitleContaining(String title);
//	List<Post> findByContentContaining(String content);
	
	// findByTitleContaining method gives error because of hibernate version.
	// @Query("select p from Post p where p.title like :key")
	// List<Post> searchByTitle(@Param("key") String title);
	
}
