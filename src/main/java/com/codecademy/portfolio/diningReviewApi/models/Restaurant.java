package com.codecademy.portfolio.diningReviewApi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

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
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CUSTOMER")
    private String CUSTOMER;

    @Column(name = "REVIEW")
    private String review;

    @Column(name = "PEANUTRATING")
    private Integer peanutRating;

    @Column(name = "EGGRATING")
    private Integer eggRating;

    @Column(name = "DAIRYRATING")
    private Integer dairyRating;

    @Column(name = "AVERAGERATING")
    private double averageRating;

    public void setId( Integer id ) {
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }
}
