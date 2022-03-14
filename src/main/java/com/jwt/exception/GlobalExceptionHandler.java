package com.jwt.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jwt.exceptionResponse.ExceptionResponse;
import com.jwt.model.JwtResponse;



//Global Exception Class
@ControllerAdvice
public class GlobalExceptionHandler {
  Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	

	
//	
//	//Handling Exception for DataNotFoundException
//	@ExceptionHandler({DataNotFoundException.class})
//	public String dataNotFoundException(DataNotFoundException ex){
//		logger.info(" === Student details  not found with {}","{}",ex);
//		
//		
//		return ex.getLocalizedMessage();
//	}
	
	//Handling Exception for DataNotFoundException
		@ExceptionHandler({BadCrendentialsException.class})
    public ResponseEntity<Object> handleExceptions( BadCrendentialsException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Not found");
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        logger.info(" === Student details  not found with {}","{}",exception);
        return entity;
    }
	
		//ResponseEntity.status(HttpStatus.OK).body(new  JwtResponse(token));
//		//Handling Exception for DataNotFoundException
//				@ExceptionHandler({ConstraintViolationException.class})
//		    public ResponseEntity<Object> ValidatorExceptions( ConstraintViolationException exception) {
//		        ExceptionResponse response = new ExceptionResponse();
//		        response.setDateTime(LocalDateTime.now());
//		        response.setMessage(exception.getMessage());
//		        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
//		        logger.info(" === Student details  not found with {}","{}",exception);
//		        return entity;
//		    }
			
				
		
		
		
		
//				@ExceptionHandler(ConstraintViolationException.class)
//				  @ResponseStatus(HttpStatus.BAD_REQUEST)
//				  @ResponseBody
//				  ValidationErrorResponse onConstraintValidationException(
//				      ConstraintViolationException e) {
//				    ValidationErrorResponse error = new ValidationErrorResponse();
//				    for (ConstraintViolation violation : e.getConstraintViolations()) {
//				      error.getViolations().add(
//				        new Violation(violation.getPropertyPath().toString(), violation.getMessage()));
//				    }
//				    return error;
//				  }
//		
//		
		
		
		


		
		
		
//		
//		//Handling Exception for DataNotFoundException
//				@ExceptionHandler({Exception.class})
//		    public ResponseEntity<Object> handleCommonExceptions( Exception exception) {
//		        ExceptionResponse response = new ExceptionResponse();
//		        response.setDateTime(LocalDateTime.now());
//		        response.setMessage("Something Went Wrong");
//		        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
//		        logger.info(" === Student details  not found with {}","{}",exception);
//		        return entity;
//		    }
//	
	
//	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
//	@ExceptionHandler(IOException.class)
//	public void handleIOException(){
//		logger.error("IOException handler executed");
//		//returning 404 error code
//	}
}



