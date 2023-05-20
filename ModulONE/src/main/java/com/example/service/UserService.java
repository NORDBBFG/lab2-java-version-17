package com.example.service;

import com.example.model.UserDTO;
import com.example.model.UserEntity;
import com.example.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;

    public UserDTO getUserByLogin(String login) {
        UserDTO userDTO =  new UserDTO();
        Optional<UserEntity> optionalUserEntity = userRepo.findByLogin(login);

        if(optionalUserEntity.isPresent()){
            UserEntity userEntity = optionalUserEntity.get();
            userDTO.setId((userEntity.getId()));
            userDTO.setLogin(userEntity.getLogin());
            userDTO.setPassword(userEntity.getPassword());
        }
        return userDTO;
    }

    public UserDTO getOrdersByUser(String orders) {
        UserDTO userDTO =  new UserDTO();
        Optional<UserEntity> optionalUserEntity = userRepo.findByOrders(orders);

        if(optionalUserEntity.isPresent()){
            UserEntity userEntity = optionalUserEntity.get();
            userDTO.setId((userEntity.getId()));
            userDTO.setLogin(userEntity.getLogin());
            userDTO.setOrders(userEntity.getOrders());
        }
        return userDTO;
    }

    public void addUser(UserDTO userDTO){
        UserEntity userEntity =  new UserEntity();
        userEntity.setLogin(userDTO.getLogin());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setOrders(userDTO.getOrders());
        userRepo.save(userEntity);
    }
}
