package com.microservices.hotel.Rating_service.services;

import com.microservices.hotel.Rating_service.entities.Rating;
import com.microservices.hotel.Rating_service.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class RatingService {
    @Autowired
    RatingRepository repository;

    public Rating create(Rating rating){
        return repository.save(rating);
    }

    public List<Rating> getRatings(){
        return repository.findAll();
    }

    public List<Rating> getRatingByUserId(String userid){
        return repository.findByUserId(userid);
    }

    public List<Rating> getRatingByHotelId(String hotelId){
        return repository.findByHotelId(hotelId);
    }

}
