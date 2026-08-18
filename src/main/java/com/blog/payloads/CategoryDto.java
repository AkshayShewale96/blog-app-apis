package com.blog.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	
	@NotBlank
	@Size(min=4, message="size must be min of 4 char !!!")
	private String categoryTitle;
	
	@NotBlank
	@Size(min =10, message="size must be min of 10 char !!")
	private String categoryDescription;
}
