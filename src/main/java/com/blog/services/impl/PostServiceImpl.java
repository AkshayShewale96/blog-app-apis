package com.blog.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.blog.Entity.Category;
import com.blog.Entity.Post;
import com.blog.Entity.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.PostDto;
import com.blog.payloads.PostResponse;
import com.blog.repository.CategoryRepo;
import com.blog.repository.PostRepo;
import com.blog.repository.UserRepo;
import com.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	// Create
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "Category Id", categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost = this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	// Update
	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		//will get old data from "postId" and will save in "postDto".
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		
		Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	//delete
	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
		this.postRepo.delete(post);
	}

//	// get all post
//	@Override
//	public List<PostDto> getAllPost() {
//		List<Post> allPosts = this.postRepo.findAll(); 
//		// converting Post.Class to PostDto.Class
//		List<PostDto> postDtos = allPosts.stream().map((Post)->this.modelMapper.map(Post, PostDto.class)).collect(Collectors.toList());
//		return postDtos;
//	}
	
	// Pagination for all post
	
	// get all post - Integer pageNumber, Integer pageSize - added for Pagination.
	// changed "List<PostDto>" to "PostResponse" to get Pagination response.
		@Override
		public PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
			
//			Sort sort = null;
//			if(sortDir.equalsIgnoreCase("asc")) {
//				sort=Sort.by(sortBy).ascending();
//			}else {
//				sort=Sort.by(sortBy).descending();
//			}
			// for ascending/ descending order
			// ternary operator used.
			Sort sort = (sortDir.equalsIgnoreCase("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
			
			//Imported from: import org.springframework.data.domain.Pageable;
			Pageable p = PageRequest.of(pageNumber, pageSize, sort);
			Page<Post> pagePost = this.postRepo.findAll(p);
			
			List<Post> allPosts = pagePost.getContent();
			// converting Post.Class to PostDto.Class
			List<PostDto> postDtos = allPosts.stream().map((Post)->this.modelMapper.map(Post, PostDto.class)).collect(Collectors.toList());
			
			// comes from PostResponse.Class
			PostResponse postResponse = new PostResponse();
			postResponse.setContent(postDtos);
			postResponse.setPageNumber(pagePost.getNumber());
			postResponse.setPageSize(pagePost.getSize());
			postResponse.setTotalElements(pagePost.getTotalElements());
			postResponse.setTotalPages(pagePost.getTotalPages());
			postResponse.setLastPage(pagePost.isLast());
			
			return postResponse;
		}

	// get post by id
	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post", "Post Id", postId));
		PostDto postDto = this.modelMapper.map(post, PostDto.class);
		return postDto;
	}

	//get post by category
	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("category", "Category Id", categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat);
		// you should take same name as lambda
		// ((post)->this.modelMapper.map(post, PostDto.class))
		// converting Post.Class to PostDto.Class
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}
	

	//get post by user
	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		// you should take same name as lambda
		// ((post)->this.modelMapper.map(post, PostDto.class))
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList()); 
		return postDtos;
	}

	// search post
	@Override
	public List<PostDto> searchPosts(String keyword) {
		List<Post> posts = this.postRepo.findByTitleContaining(keyword);
//		List<Post> posts = this.postRepo.searchByTitle("%"+keyword+"%");
		List<PostDto> postDtos = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

}
