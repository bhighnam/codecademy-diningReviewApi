package com.codecademy.portfolio.diningReviewApi.models;

import com.codecademy.portfolio.diningReviewApi.enums.DiningStatus;

// auto generate setters and getters with lombok
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class AdminReview {
    
    @Setter( AccessLevel.PUBLIC )
    @Getter
    private Integer diningReviewId;

    @Setter( AccessLevel.PUBLIC )
    @Getter
    private DiningStatus status;

}
