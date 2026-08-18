package com.blog.services;

import java.util.List;

import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;

public interface PostService {

	//create
	//userId, categoryId added bcoz in Post.Class we have ManyToOne mapping.
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	// get all post-Pagination
	// get all post - Integer pageNumber, Integer pageSize - added for Pagination.
	// changed return Type "List<PostDto>" to "PostResponse" to get Pagination response.
	PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	//get by id
	PostDto getPostById(Integer postId);
	
	// get all posts by Category ---- Custom finder method created in PostRepo.
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	
	// get all Posts by User ---- Custom finder method created in PostRepo.
	List<PostDto> getPostsByUser(Integer userId);
	
	// Search Post - new method ---- Custom finder method created in PostRepo.
	List<PostDto> searchPosts(String keyword);
}
