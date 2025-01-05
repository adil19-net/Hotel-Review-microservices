package com.microservices.hotel.Rating_service.controllers;

import com.microservices.hotel.Rating_service.entities.Rating;
import com.microservices.hotel.Rating_service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    RatingService service;

    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        Rating rating1=service.create(rating);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAll(){
        return new ResponseEntity<>(service.getRatings(),HttpStatus.ACCEPTED);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<Rating>> getByUserId(@PathVariable String userId){
        List<Rating> rating1=service.getRatingByUserId(userId);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }

    @GetMapping("hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getByHotelId(@PathVariable String hotelId){
        List<Rating> rating1=service.getRatingByHotelId(hotelId);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
    }
}
