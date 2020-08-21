package com.buildingblocks.bootrestv2.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class CustomErrorDetails {
    private Date timestamp;
    private String message;
    private String errorDetails;

    public CustomErrorDetails(){}

    public CustomErrorDetails(Date timestamp, String message, String errorDetails) {
        this.timestamp = timestamp;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(String errorDetails) {
        this.errorDetails = errorDetails;
    }

    @Override
    public String toString() {
        return "CustomErrorDetails{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", errorDetails='" + errorDetails + '\'' +
                '}';
    }
}
