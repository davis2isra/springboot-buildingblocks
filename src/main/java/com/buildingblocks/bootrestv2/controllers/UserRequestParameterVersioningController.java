package com.buildingblocks.bootrestv2.controllers;

import com.buildingblocks.bootrestv2.dtos.UserDtoV1;
import com.buildingblocks.bootrestv2.dtos.UserDtoV2;
import com.buildingblocks.bootrestv2.dtos.UserMmDto;
import com.buildingblocks.bootrestv2.entities.User;
import com.buildingblocks.bootrestv2.exceptions.UserNotFoundException;
import com.buildingblocks.bootrestv2.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@RequestMapping("/versioning/params/users")
public class UserRequestParameterVersioningController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}", params="version=1")
    public UserDtoV1 getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException{

        Optional<User> userOptional = userService.getUserById(id);

        if(!userOptional.isPresent()){
            throw new UserNotFoundException("User not found");
        }

        User user = userOptional.get();

        UserDtoV1 userDtoV1 = modelMapper.map(user, UserDtoV1.class);
        return userDtoV1;

    }

    @GetMapping(value = "/{id}", params="version=2")
    public UserDtoV2 getUserByIdv2(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException{

        Optional<User> userOptional = userService.getUserById(id);

        if(!userOptional.isPresent()){
            throw new UserNotFoundException("User not found");
        }

        User user = userOptional.get();

        UserDtoV2 userDtoV2 = modelMapper.map(user, UserDtoV2.class);
        return userDtoV2;

    }
}
