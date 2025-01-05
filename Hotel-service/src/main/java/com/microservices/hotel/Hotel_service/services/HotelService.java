package com.microservices.hotel.Hotel_service.services;

import com.microservices.hotel.Hotel_service.entities.Hotel;
import com.microservices.hotel.Hotel_service.exceptions.ResourceNotFoundException;
import com.microservices.hotel.Hotel_service.repositories.HotelRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelService {
    @Autowired
    HotelRepository repository;

    public Hotel create(Hotel hotel){
        String id= String.valueOf(UUID.randomUUID());
        hotel.setId(id);
        repository.save(hotel);
        return hotel;
    }

    public List<Hotel> getAll(){
        return repository.findAll();
    }
    public Hotel getHotel(String id){
        Optional<Hotel> byId = repository.findById(id);
        if(byId.isPresent()){
            return byId.get();
        }
        return new Hotel();
//        throw new ResourceNotFoundException("No hotel found!");
    }

}
