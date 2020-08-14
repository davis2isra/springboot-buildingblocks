package com.buildingblocks.bootrestv2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorDetails {
    private Date timestamp;
    private String message;
    private String errorDetails;


}
