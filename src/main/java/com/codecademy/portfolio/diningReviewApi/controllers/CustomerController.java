package com.codecademy.portfolio.diningReviewApi.controllers;

import java.util.Optional;

import com.codecademy.portfolio.diningReviewApi.models.Customer;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codecademy.portfolio.diningReviewApi.repositories.CustomerRepository;

// contains all of the APIs for handling customer
@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;

    public CustomerController(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // create customer user
    @PostMapping("/customer/create")
    public Customer createNewCustomer( @RequestBody Customer customer ) {
        Customer newCustomer = this.customerRepository.save( customer );
        return newCustomer;
    }

    @GetMapping("/customer/search")
    public Customer findCustomerByUserName( @RequestBody Customer customer ) {
       Customer customerToBeSearched = customer;
       Customer fetchCustomer = this.customerRepository.findByCustomerName(customerToBeSearched.getCustomerName());
       
       System.out.println( "customerName --> " + customerToBeSearched.getCustomerName() );
       //System.out.println( "customer name --> " + fetchCustomer.getCustomerName() );
       if( fetchCustomer == null ) {
            System.out.println( "Customer not found" );
            return null;
       }
       else {
            System.out.println( "Customer " + fetchCustomer.getCustomerName() + " found!" );
            return fetchCustomer;
       }
    }
}
