package com.codecademy.portfolio.diningReviewApi.controllers;

import java.util.Optional;

import com.codecademy.portfolio.diningReviewApi.models.Customer;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    // find customer by username
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
    
    // update user info and do not update username
    @PutMapping("/customer/update")
    public Customer updateCustomerInfo( @RequestBody Customer customer ) {
        
        // check if the customer exists
        Customer customerToBeUpdated;

        if( ( this.customerRepository.findByCustomerName( customer.getCustomerName() ) ) == null ) {
            System.out.println( "Unable to find customer " + customer.getCustomerName() + "!" + "Not updating" );
            return null;
        }
        // record has been found
        else {
            System.out.println( "Record found! Commencing update procedures" );
            customerToBeUpdated = this.customerRepository.findByCustomerName( customer.getCustomerName() );

            // updating customer record values
            if( customer.getCity() == null ) {
                System.out.println( "No updates for city" );
            }
            else {
                System.out.println( customer.getCity() );
                customerToBeUpdated.setCity( customer.getCity() );            
            }

            if( customer.getState() == null ) {
                System.out.println( "No updates for state" );
            }
            else {
                System.out.println( customer.getState() );
                customerToBeUpdated.setState( customer.getState() );
            }

            if( customer.getInterestDairy() == null ) {
                System.out.println( "No updates fo Interest in diary" );
            }
            else {
                System.out.println( customer.getInterestDairy() );
                customerToBeUpdated.setInterestDairy( customer.getInterestDairy() );
            }

            if( customer.getInterestEgg() == null ) {
                System.out.println( "No updates fo Interest in Egg" );
            }
            else {
                System.out.println( customer.getInterestEgg() );
                customerToBeUpdated.setInterestEgg( customer.getInterestEgg() );
            }

            if( customer.getInterestPeanut() == null ) {
                System.out.println( "No updates fo Interest in Peanut" );
            }
            else {
                System.out.println( customer.getInterestPeanut() );
                customerToBeUpdated.setInterestPeanut( customer.getInterestPeanut() );
            }
            
            this.customerRepository.save( customerToBeUpdated );
            return customerToBeUpdated;
        }
    }
}
