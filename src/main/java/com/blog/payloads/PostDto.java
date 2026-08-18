package com.blog.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.Entity.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PostDto {

	private Integer postId;
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	// CategoryDto is used to stop infinite loop - in postman
	// In CategoryDto Post is not mentioned so no infinite loop.
	private CategoryDto category;
	
	// UserDto is used to stop infinite loop - in postman
    // In UserDto Post is not mentioned so no infinite loop.
	private UserDto user;
	
	// CommentDto is used to stop infinite loop - in postman
    // In CommentDto.Class Post is not mentioned so no infinite loop.
	private Set<CommentDto> comments = new HashSet<>();
}
