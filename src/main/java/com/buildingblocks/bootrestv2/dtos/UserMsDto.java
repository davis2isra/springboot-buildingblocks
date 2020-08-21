package com.buildingblocks.bootrestv2.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMsDto {
    private Long id;
    private String username;
    private String emailaddress;

}
