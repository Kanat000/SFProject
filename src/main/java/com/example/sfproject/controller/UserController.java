package com.example.sfproject.controller;


import com.example.sfproject.entity.UserEntity;
import com.example.sfproject.model.LoginRequest;
import com.example.sfproject.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    final UserService userService;

    @PostMapping("/login")
    public boolean logIn(@RequestBody LoginRequest loginRequest){
        return userService.logIn(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserEntity userEntity){
        return userService.register(userEntity);
    }

    @GetMapping("/getUser")
    public UserEntity getUser(@RequestParam String email){
        return userService.getUser(email);
    }
}
