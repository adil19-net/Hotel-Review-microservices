package com.microservices.hotel.Hotel_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> returnError(ResourceNotFoundException exc){
        return new ResponseEntity<ApiResponse>(new ApiResponse(exc.getMessage()), HttpStatus.NOT_FOUND);
    }
}
