package com.codecademy.portfolio.diningReviewApi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.portfolio.diningReviewApi.models.Customer;

public interface CustomerRepository extends CrudRepository <Customer, Integer> {
    /**
        As an unregistered user, I want to create my user profile using a display name that’s unique only to me.
        As a registered user, I want to update my user profile. I cannot modify my unique display name.
    */

    // TODO: create User info
    public Customer findByCustomerName( String customerName );

}
