package com.buildingblocks.bootrestv2.exceptions;

public class UserExistsException extends Exception {

    public UserExistsException(String message) {
        super(message);
    }
}
