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
@Table( name = "customers" )
public class Customer {

    /*
        their display name, one that’s unique to only that user
        city
        state
        zipcode
        whether they’re interested in peanut allergies
        whether they’re interested in egg allergies
        whether they’re interested in dairy allergies
     */
    @Id
    @GeneratedValue
    @Setter( AccessLevel.PUBLIC )
    @Getter
    private Integer id;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "customer_name")
    private String customerName;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "city")
    private String city;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "state")
    private String state;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "interest_peanut")
    private Integer interestPeanut = 1;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "interest_egg")
    private Integer interestEgg = 1;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "interest_dairy")
    private Integer interestDairy = 1;
}
