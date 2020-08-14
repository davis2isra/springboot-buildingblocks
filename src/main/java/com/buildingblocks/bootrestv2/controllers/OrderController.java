package com.buildingblocks.bootrestv2.controllers;

import com.buildingblocks.bootrestv2.entities.Order;
import com.buildingblocks.bootrestv2.entities.User;
import com.buildingblocks.bootrestv2.exceptions.UserNotFoundException;
import com.buildingblocks.bootrestv2.repositories.OrderRepository;
import com.buildingblocks.bootrestv2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class OrderController {

    @Autowired
    private UserRepository userRespository;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{userid}/orders")
    public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {

        Optional<User> userOptional = userRespository.findById(userid);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User Not Found");

        return userOptional.get().getOrders();
    }

    @PostMapping("{userid}/orders")
    public Order createOrder(@PathVariable Long userid, @RequestBody Order order ) throws UserNotFoundException{
        Optional<User> userOptional = userRespository.findById(userid);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User not found.");

        User user = userOptional.get();
        order.setUser(user);
        return orderRepository.save(order);
    }

    @GetMapping("/{userid}/orders/{orderid}")
    public Order getOrderByOrderId(@PathVariable Long userid, @PathVariable Long orderid) throws UserNotFoundException {
        Optional<User> userOptional = userRespository.findById(userid);
        if(!userOptional.isPresent())
            throw new UserNotFoundException("User not found.");

        User user = userOptional.get();
        List<Order> orders = user.getOrders();
        for ( Order order: orders) {
            System.out.println("OrderId: " + order.getOrderId());
            System.out.println("Order Description: " + order.getDescription());
            System.out.println("Order user: " + order.getUser().getId());
            System.out.println("El resultado de la comparacion (Long) order.getOrderId() == (Long) orderid es: " +
                    (order.getOrderId().longValue() == orderid) );
            if(order.getOrderId().longValue() == orderid) {
                System.out.println("Ya entro en el if jejeje");
                return order;
            }
        }
        return null;
    }
}
