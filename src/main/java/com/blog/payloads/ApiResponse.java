package com.blog.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



 @Getter
 @Setter
 @NoArgsConstructor
 @AllArgsConstructor

 // this class is used in GlobalExceptionHandler Class and in Controller(delete API)
 // to give Error message like : User Not Found with ID:__ , false.
 // will get message from ResourceNotFoundException.Class for GlobalExceptionHandler.
 
public class ApiResponse {
	private String message;
	private boolean success;

}
