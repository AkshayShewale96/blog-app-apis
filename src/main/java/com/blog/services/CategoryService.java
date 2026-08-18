package com.blog.services;

import java.util.List;

import com.blog.payloads.CategoryDto;

public interface CategoryService {

	// in interface all methods are public and abstract
	// no need of public modifier
	
	// create
	CategoryDto createCat(CategoryDto categoryDto);
	
	// update
	CategoryDto updateCat(CategoryDto categoryDto, Integer categoryId);
	
	// get by id
	CategoryDto getCat(Integer categoryId);
	
	// get all
	List<CategoryDto> getAllCat();
	
	// delete
	void deleteCat(Integer categoryId);
}
