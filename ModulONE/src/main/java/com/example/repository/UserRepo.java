package com.example.repository;

import com.example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByLogin(String login);
    Optional<UserEntity> findByOrders(String orders);

}
