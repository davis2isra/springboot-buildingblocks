package com.buildingblocks.bootrestv2.controllers;

import com.buildingblocks.bootrestv2.entities.User;
import com.buildingblocks.bootrestv2.exceptions.UserNotFoundException;
import com.buildingblocks.bootrestv2.services.UserService;
import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping(value="/jacksonfilter/users")
@Validated
public class UserMappingJacksonController {
    @Autowired
    private UserService userService;

    // getUserById - fields with hashset
    @GetMapping("/{id}")
    public MappingJacksonValue getUserById(@PathVariable("id") @Min(1) Long id) {
        try {
            Optional<User> userOptional = userService.getUserById(id);
            User user = userOptional.get();

            Set<String> fields = new HashSet<String>();
            fields.add("id");
            fields.add("username");
            fields.add("ssn");
            fields.add("orders");

            FilterProvider filterProvider = new SimpleFilterProvider()
                    .addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));

            MappingJacksonValue mapper = new MappingJacksonValue(user);
            mapper.setFilters(filterProvider);

            return mapper;
        } catch (UserNotFoundException unfe){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, unfe.getMessage());
        }

    }

    // getUserById - fields with hashset
    @GetMapping("/params/{id}")
    public MappingJacksonValue getUserById2(@PathVariable("id") @Min(1) Long id,
                                            @RequestParam Set<String> fields) {
        try {
            Optional<User> userOptional = userService.getUserById(id);
            User user = userOptional.get();

            FilterProvider filterProvider = new SimpleFilterProvider()
                    .addFilter("userFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fields));

            MappingJacksonValue mapper = new MappingJacksonValue(user);
            mapper.setFilters(filterProvider);

            return mapper;
        } catch (UserNotFoundException unfe){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, unfe.getMessage());
        }

    }
}
