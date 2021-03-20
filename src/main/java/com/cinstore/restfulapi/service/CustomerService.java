package com.cinstore.restfulapi.service;

import com.cinstore.restfulapi.entity.Customer;
import com.cinstore.restfulapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer checkLogin(String id, String password) {
        return customerRepository.findCustomerByIdCusAndPasswordCus(id, password);
    }
}
