package com.qoppa.userservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qoppa.userservice.dtos.ResponseDTO;
import com.qoppa.userservice.models.User;
import com.qoppa.userservice.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseDTO> getUser(@PathVariable("id") Long userId) {
        ResponseDTO responseDto = userService.getUser(userId);
        return ResponseEntity.ok(responseDto);
    }
}
