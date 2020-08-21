package com.buildingblocks.bootrestv2.controllers;

import com.buildingblocks.bootrestv2.dtos.UserMsDto;
import com.buildingblocks.bootrestv2.mappers.UserMapper;
import com.buildingblocks.bootrestv2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mapstruct/users")
public class UserMapStructController {

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //public UserMapper userMapper;

    @GetMapping
    public List<UserMsDto> getAllUserDtos() {
        //return userMapper.userToUserDtos(userRepository.findAll());
        return null;
    }


}
