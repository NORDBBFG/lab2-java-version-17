package com.example.controller;

import com.example.model.UserDTO;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public @ResponseBody void addUser(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
    }

    @GetMapping("/get")
    public @ResponseBody UserDTO getUserByLogin(@RequestParam String login){
        return userService.getUserByLogin(login);
    }
    @GetMapping("/get/orders")
    public @ResponseBody UserDTO getOrdersByUser(@RequestParam String orders){
        return userService.getOrdersByUser(orders);
    }
}
