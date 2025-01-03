package com.codecademy.portfolio.diningReviewApi.models;

import com.codecademy.portfolio.diningReviewApi.enums.DiningStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

// auto generate setters and getters with lombok
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dining_review")
public class DiningReview {

    /*
       who submitted, represented by their unique display name (String)
       the restaurant, represented by its Id (Long)
       an optional peanut score, on a scale of 1-5
       an optional egg score, on a scale of 1-5
       an optional dairy score, on a scale of 1-5
       an optional commentary
     */
    
    @Id
    @GeneratedValue
    @Setter( AccessLevel.PUBLIC )
    @Getter
    private Integer id;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "customer_id")
    private Integer customerId; // references 1-N

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "customer_name")
    private String customerName; // references 1-N

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "resturant_id")
    private Integer resturantId; // references 1-N

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "peanut_score")
    private Integer peanutScore;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "egg_score")
    private Integer eggScore;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "diary_score")
    private Integer dairyScore;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "status")
    private DiningStatus status = DiningStatus.PENDING;
}
