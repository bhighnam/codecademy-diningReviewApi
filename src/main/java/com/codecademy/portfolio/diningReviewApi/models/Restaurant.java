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
@Table(name = "restaurants")
public class Restaurant {
    // id
    // name
    // peanutRating( average of all users peanut rating from 1 to 5 )
    // eggRating( average of all users egg rating from 1 to 5 )
    // dairyRating( average of all users dairy rating from 1 to 5 )
    // averageRating( avg. peanut, egg, Dairy amongst all of the users )

    @Id
    @GeneratedValue
    @Setter( AccessLevel.PUBLIC )
    @Getter
    private Integer id;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "name")
    private String name;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "peanut_rating")
    private Integer peanutRating;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "egg_rating")
    private Integer eggRating;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "dairy_rating")
    private Integer dairyRating;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    @Column(name = "average_rating")
    private double averageRating;

}
