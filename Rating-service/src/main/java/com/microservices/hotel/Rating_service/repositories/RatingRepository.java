package com.microservices.hotel.Rating_service.repositories;

import com.microservices.hotel.Rating_service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String> {


    List<Rating> findByUserId(String userid);
    List<Rating> findByHotelId(String userid);
}