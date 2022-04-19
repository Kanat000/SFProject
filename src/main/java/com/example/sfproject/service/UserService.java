package com.example.sfproject.service;


import com.example.sfproject.entity.UserEntity;
import com.example.sfproject.model.LoginRequest;
import com.example.sfproject.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    final UserRepo userRepo;

    public UserEntity getUser(String email){
        if(userRepo.existsUserEntityByEmail(email))
            return userRepo.getUserEntityByEmail(email);
        return null;
    }
    public boolean logIn(LoginRequest loginRequest){

        if(userRepo.existsUserEntityByEmail(loginRequest.getEmail())){
            UserEntity user = userRepo.getUserEntityByEmail(loginRequest.getEmail());

            return user.getPass().equals(loginRequest.getPass());
        }
        return false;

    }
    public ResponseEntity<String> register(UserEntity userEntity) {
        if (!userRepo.existsUserEntityByEmail(userEntity.getEmail())){
            userRepo.save(userEntity);
            return ResponseEntity.ok().body("User Saved");
        }
        return ResponseEntity.badRequest().body("User not saved");
    }



}
