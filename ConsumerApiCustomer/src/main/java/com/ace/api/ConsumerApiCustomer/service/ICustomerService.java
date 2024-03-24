package com.ace.api.ConsumerApiCustomer.service;

import com.ace.api.ConsumerApiCustomer.model.entity.Customer;

import java.util.ArrayList;

public interface ICustomerService {

    public Customer findById(Integer id, String apiKey);
    public ArrayList<Customer> findAll(String apiKey);
}
