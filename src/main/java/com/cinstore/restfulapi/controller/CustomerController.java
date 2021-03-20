package com.cinstore.restfulapi.controller;

import com.cinstore.restfulapi.entity.Customer;
import com.cinstore.restfulapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    //checkLogin
    @PostMapping("/login")
    public String Login(@RequestBody Customer customer) {

        customer = service.checkLogin(customer.getIdCus(), customer.getPasswordCus());

        if (customer == null) {
            return "Failed";
        }

        return "Success";
    }
}
