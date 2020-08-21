package com.buildingblocks.bootrestv2.dtos;

import com.buildingblocks.bootrestv2.entities.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoV2 {

    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String role;
    private String ssn;

    private List<Order> orders;
    private String address;
}
