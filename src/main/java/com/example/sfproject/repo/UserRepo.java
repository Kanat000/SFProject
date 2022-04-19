package com.example.sfproject.repo;

import com.example.sfproject.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {
    boolean existsUserEntityByEmail(String email);
    UserEntity getUserEntityByEmail(String email);
}
