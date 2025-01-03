package com.microservices.hotel.User_service.controller;

import com.microservices.hotel.User_service.entities.User;
import com.microservices.hotel.User_service.exceptions.ResourceNotFoundException;
import com.microservices.hotel.User_service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = service.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable String id){
        User user1 = service.getUser(id);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @GetMapping("hi")
    public String print() {
        return "Hi";
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users=service.getALlUsers();
        if(users.size()==0){
            throw new ResourceNotFoundException("No user found!");
        }
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }


}
