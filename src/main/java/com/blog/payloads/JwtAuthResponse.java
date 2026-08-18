package com.blog.payloads;

import lombok.Data;

@Data
public class JwtAuthResponse {

	private String token;
	
//	added for response when we run code on React will get Token and User Details.
	private UserDto user;
}
