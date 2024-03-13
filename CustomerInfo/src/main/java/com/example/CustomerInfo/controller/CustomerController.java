package com.example.CustomerInfo.controller;

import com.example.CustomerInfo.model.Customer;
import com.example.CustomerInfo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/customersss")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @GetMapping(value = "/getcustom")
    public List<Customer> getAllCustomers(){
        return customerService.getCustomers();
    }

}
