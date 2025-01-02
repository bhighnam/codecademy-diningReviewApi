package com.codecademy.portfolio.diningReviewApi.models;

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
@Table(name = "RESTAURANTS")
public class Restaurant {
    // id
    // name
    // user
    // review
    // peanutRating
    // eggRating
    // dairyRating
    // averageRating( avg. peanut, egg, Dairy )

    @Id
    @GeneratedValue
    @Setter( AccessLevel.PUBLIC )
    @Getter
    private Integer id;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "NAME")
    private String name;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "CUSTOMER")
    private String CUSTOMER;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "REVIEW")
    private String review;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "PEANUTRATING")
    private Integer peanutRating;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "EGGRATING")
    private Integer eggRating;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "DAIRYRATING")
    private Integer dairyRating;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "AVERAGERATING")
    private double averageRating;

}
