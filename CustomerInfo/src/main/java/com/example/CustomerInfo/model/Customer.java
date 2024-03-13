package com.example.CustomerInfo.model;

import lombok.Data;

@Data
public class Customer {
    private int customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
}
