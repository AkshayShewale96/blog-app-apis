package com.blog.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
	// This class is Response for Pagination (Postman)
	// In PostService change for "getAllPost" change List<PostDto> to PostResponse.
	// PostServiceImpl and PostController also.
	// same as "List<PostDto>".
	private List<PostDto> content;
	private int pageNumber;
	private int pageSize;
	private Long totalElements;
	private int totalPages;
	private boolean lastPage;
	
}
