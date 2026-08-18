package com.blog.payloads;

import java.util.HashSet;
import java.util.Set;

import com.blog.Entity.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	
	// these annotations are for validation
	// in controller annotated with @Valid for enable
	// added dependency for this in pom.xml
	// these message will reflect in postman.
	// for that created method in GlobalExceptionHandler class
	
	private int id;
	
	@NotEmpty
	@Size(min=4, message="Username must be min of 4characters !!")
	private String name;
	
	@NotEmpty(message="email is required !!")
	@Email(message="Email address is not valid !!")
	private String email;
	
	@NotEmpty
	@Size(min=3, max=10, message="Password must be min of 3 char and max of 10 char !!")
	private String password;
	
	@NotEmpty
	private String about;

	private Set<RoleDto> roles = new HashSet<>();
	
//	Don't show password in response (Front End React -Token and User details)
	@JsonIgnore
	public String getPassword() {
		return this.password;
	}
//  because of JSON ignore getting error at Sign up to set password.(React)	
	@JsonProperty
	public void setPassword(String password) {
		this.password=password;
	}
}
