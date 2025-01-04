package com.codecademy.portfolio.diningReviewApi.controllers;

import com.codecademy.portfolio.diningReviewApi.models.Restaurant;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codecademy.portfolio.diningReviewApi.repositories.RestaurantRepository;

@RestController
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    public RestaurantController(final RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // create restaurant validate that restaurant name has not been used
    @PostMapping("/restaurant/create")
    public Restaurant createNewRestaurant( @RequestBody Restaurant newRestaurant ) {
        // validate if the restaurant name have not been used
        if( this.restaurantRepository.findByRestaurantName( newRestaurant.getRestaurantName() ) == null ) {
            System.out.println( "Restaurant has not been found! Creating record" );
            this.restaurantRepository.save( newRestaurant );
            return newRestaurant;
        }
        System.out.println( "Restaurant has been found! Not creating record" );
        return null;
    }

    // get restaurant by id
    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurantById( @PathVariable("id") Integer restaurantId ) {
        return ( this.restaurantRepository.findById( restaurantId ) ).get();
    }

    // modify restaurant
    
}
