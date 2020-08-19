package com.buildingblocks.bootrestv2.controllers;

import com.buildingblocks.bootrestv2.entities.User;
import com.buildingblocks.bootrestv2.entities.Views;
import com.buildingblocks.bootrestv2.exceptions.UserNotFoundException;
import com.buildingblocks.bootrestv2.services.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.Optional;

@RestController
@Validated
@RequestMapping(value="/jsonview/users")
public class UserJsonViewController {
    @Autowired
    private UserService userService;

    @GetMapping("/external/{id}")
    @JsonView(Views.External.class)
    public Optional<User> getUserById(@PathVariable("id") @Min(1) Long id) {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException unfe){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, unfe.getMessage());
        }

    }

    @GetMapping("/internal/{id}")
    @JsonView(Views.Internal.class)
    public Optional<User> getUserById2(@PathVariable("id") @Min(1) Long id) {
        try {
            return userService.getUserById(id);
        } catch (UserNotFoundException unfe){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, unfe.getMessage());
        }

    }
}
