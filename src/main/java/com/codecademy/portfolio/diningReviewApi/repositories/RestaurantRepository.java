package com.codecademy.portfolio.diningReviewApi.repositories;

import org.springframework.data.repository.CrudRepository;
import com.codecademy.portfolio.diningReviewApi.models.Restaurant;

public interface RestaurantRepository extends CrudRepository <Restaurant, Integer> {
    public Restaurant findByRestaurantName( String restaurantName );
}
