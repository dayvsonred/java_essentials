package com.cloud.microsevices.cloud.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler {
	
	
	@ExceptionHandler(com.cloud.microsevices.cloud.exception.ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(com.cloud.microsevices.cloud.exception.ObjectNotFoundException e, HttpServletRequest request) {
		
	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	

}
