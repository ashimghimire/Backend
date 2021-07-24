package com.cotiviti.demo.controller;

import com.cotiviti.demo.Repository.UserRepository;
import com.cotiviti.demo.entity.Users;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping(path="/api")
    public @ResponseBody String login(@RequestBody Users user){
        return null;
    }

}
