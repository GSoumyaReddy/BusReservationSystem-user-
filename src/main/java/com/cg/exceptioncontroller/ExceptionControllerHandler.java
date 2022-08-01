package com.cg.exceptioncontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.exceptions.UserNotFoundException;

@ControllerAdvice

public class ExceptionControllerHandler {

	@SuppressWarnings({"rawtypes","unchecked"})	
	@ExceptionHandler(value = UserNotFoundException.class)
    
    public ResponseEntity<Object> handleUserException(Exception ex){
        return new ResponseEntity<Object>("User Not Found",HttpStatus.NOT_FOUND);
    }
}