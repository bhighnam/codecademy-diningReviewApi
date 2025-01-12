package com.codecademy.portfolio.diningReviewApi.controllers;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codecademy.portfolio.diningReviewApi.models.DiningReview;
import com.codecademy.portfolio.diningReviewApi.models.Restaurant;
import com.codecademy.portfolio.diningReviewApi.models.Customer;
import com.codecademy.portfolio.diningReviewApi.repositories.CustomerRepository;
import com.codecademy.portfolio.diningReviewApi.repositories.DiningReviewRepository;
import com.codecademy.portfolio.diningReviewApi.repositories.RestaurantRepository;

@RestController
public class DiningReviewController {

    private final DiningReviewRepository diningReviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final CustomerRepository customerRepository;

    public DiningReviewController(  final DiningReviewRepository diningReviewRepository, 
                                    final RestaurantRepository restaurantRepository,
                                    final CustomerRepository customerRepository ) {
        this.diningReviewRepository = diningReviewRepository;
        this.restaurantRepository = restaurantRepository;
        this.customerRepository = customerRepository;
    }

    // create dining review record
    @PostMapping("/review/create")
    public DiningReview createDiningReview( @RequestBody DiningReview diningReview ) {

        // verify from the body of the request that the restaurant exist
        Optional<Restaurant> restaurantRecordFound = this.restaurantRepository.findById( diningReview.getRestaurantId() );
        Optional<Customer> customerRecordFound = this.customerRepository.findById( diningReview.getCustomerId() );

        // resturant found!
        if( restaurantRecordFound.isPresent() ) {
            System.out.println( "Restaurant record found! Customer looking for Restaurant name --> " + restaurantRecordFound.get().getRestaurantName() );
        }
        else {
            System.out.println( "Restaurant record not found!" );
            return null;
        }
        
        // customer found
        if( customerRecordFound.isPresent() ) {
            System.out.println( "Custimer record found! Customer found customer ID --> " + customerRecordFound.get().getCustomerName() );
        }
        else {
            System.out.println( "Customer record not found!" );
            return null;
        }

        // processing review
        System.out.println( "Processing dining review" );
        this.diningReviewRepository.save( diningReview );
        return diningReview;
    }

    @GetMapping( "/review/{id}" )
    public DiningReview getDiningReviewById( @PathVariable("id") Integer diningReviewId ) {
        Optional<DiningReview> diningReviewOptional = this.diningReviewRepository.findById( diningReviewId );

        if( diningReviewOptional.isPresent() ) {
            System.out.println( "dining Review found!" );
            return diningReviewOptional.get();
        }
        else {
            System.out.println( "Dining review not found" );
            return null;
        }
    }
}
