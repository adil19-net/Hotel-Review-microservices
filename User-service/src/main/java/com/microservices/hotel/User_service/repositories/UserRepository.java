package com.microservices.hotel.User_service.repositories;

import com.microservices.hotel.User_service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {

}
