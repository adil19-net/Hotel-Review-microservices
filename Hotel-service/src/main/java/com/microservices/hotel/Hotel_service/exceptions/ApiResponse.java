package com.microservices.hotel.Hotel_service.exceptions;

public class ApiResponse {
    String message;

    public ApiResponse(String message) {
        this.message = message;
    }

    public ApiResponse() {
    }
}
