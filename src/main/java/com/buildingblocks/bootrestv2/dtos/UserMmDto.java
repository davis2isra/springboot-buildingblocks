package com.buildingblocks.bootrestv2.dtos;

import com.buildingblocks.bootrestv2.entities.Order;
import lombok.Data;

import java.util.List;

@Data
public class UserMmDto {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private List<Order> orders;
}
