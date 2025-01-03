package com.microservices.hotel.User_service.services;

import com.microservices.hotel.User_service.entities.User;
import com.microservices.hotel.User_service.exceptions.ResourceNotFoundException;
import com.microservices.hotel.User_service.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
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
        if(byId.isPresent()){
            return byId.get();
        }
        throw new ResourceNotFoundException("User not found");
    }

    public User updateUser(User user){
        return null;
    }

    public void deleteUser(User user){
//        return null;
    }
}
