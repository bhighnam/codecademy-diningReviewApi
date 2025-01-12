package com.codecademy.portfolio.diningReviewApi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codecademy.portfolio.diningReviewApi.models.DiningReview;

public interface DiningReviewRepository extends CrudRepository<DiningReview, Integer> {
    
}
