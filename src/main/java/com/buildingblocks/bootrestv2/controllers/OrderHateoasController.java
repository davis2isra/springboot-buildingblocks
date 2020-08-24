package com.buildingblocks.bootrestv2.controllers;

import com.buildingblocks.bootrestv2.entities.Order;
import com.buildingblocks.bootrestv2.entities.User;
import com.buildingblocks.bootrestv2.exceptions.UserNotFoundException;
import com.buildingblocks.bootrestv2.repositories.OrderRepository;
import com.buildingblocks.bootrestv2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.CollectionModel;
//import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/hateoas/users")
public class OrderHateoasController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    /*@GetMapping("/{userid}/orders")
    public CollectionModel<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {

        Optional<User> userOptional = userRepository.findById(userid);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User Not Found");

        List<Order> allOrders =  userOptional.get().getOrders();
        CollectionModel<Order> finalResources = new CollectionModel<Order>(allOrders);
        return finalResources;
    }*/
}
