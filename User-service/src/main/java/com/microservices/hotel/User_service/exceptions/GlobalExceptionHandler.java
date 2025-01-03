package com.microservices.hotel.User_service.exceptions;

import com.microservices.hotel.User_service.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundExc(ResourceNotFoundException exc){
        return new ResponseEntity<>(new ApiResponse(exc.getMessage(),true, HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }

}
