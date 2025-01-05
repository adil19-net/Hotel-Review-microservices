package com.microservices.hotel.Hotel_service.repositories;

import com.microservices.hotel.Hotel_service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
