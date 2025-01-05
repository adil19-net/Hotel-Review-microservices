package com.microservices.hotel.User_service.services;

import com.microservices.hotel.User_service.entities.Hotel;
import com.microservices.hotel.User_service.entities.Rating;
import com.microservices.hotel.User_service.entities.User;
import com.microservices.hotel.User_service.exceptions.ResourceNotFoundException;
import com.microservices.hotel.User_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    RestTemplate restTemplate;

    public User saveUser(User user){
        String uid= String.valueOf(UUID.randomUUID());
        user.setUserId(uid);
        repository.save(user);
        return user;
    }

    public List<User> getALlUsers(){
        List<User> l1 = repository.findAll();
        return l1;
    }

    public User getUser(String userId){
        Optional<User> byId = repository.findById(userId);
        if(byId.isEmpty()){
            throw new ResourceNotFoundException("User not found");
        }
        User user=byId.get();
        String url="http://localhost:8083/ratings/users/{userId}";
        Rating[] ratings1 = restTemplate.getForObject(url, Rating[].class, userId);
        List<Rating> ratings=Arrays.asList(ratings1);

        List<Rating> finalRatings = ratings.stream().map(rating -> {
            Hotel hotel=restTemplate.getForObject("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel= hotelService.createHotel(rating.getHotelId());
            rating.setHotel(new Hotel());
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(finalRatings);
        return user;
    }

    public User updateUser(User user){
        return null;
    }

    public void deleteUser(User user){
//        return null;
    }
}
