package com.blog.exceptions;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.blog.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	// This method use ApiResponse Class to create error message.
	// like: User not found with Id:__ , false.
	// it will take message from ResourceNotFoundException Class.
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	// this method is for validation
	// we use validation dependency and annotated the fields so it will throw exception
	// to handle that exception and show correct message we added this method
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		Map<String,String> resp = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);
		});
		return new ResponseEntity<Map<String,String>>(resp,HttpStatus.BAD_REQUEST);
	}
	
	// This Method handles exception when we didn't send "Id" in URL
	// (update, delete)
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
		//String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse("mention 'Id' in URL", false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	// This Method handles exception when we didn't send/ Wrong password in TOKEN GENERATION
	// JwtAuthRequest
	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ApiResponse> handleException(Exception ex){
//		//String message = ex.getMessage();
//		ApiResponse apiResponse = new ApiResponse("Password is WRONG", false);
//		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ApiResponse> handleApiException(ApiException ex){
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse(message, false);
		return new ResponseEntity<ApiResponse>(apiResponse,HttpStatus.BAD_REQUEST);
	}	
}


