package com.upwork.test.service;

import org.springframework.stereotype.Component;

/**
 * Created by Titan on 18.04.2017.
 */
@Component
public class BaggageService {
    public Boolean checkIn(Long destinationId, String baggageId) {
        return stubCheckInResponse(destinationId);
    }

    private boolean stubCheckInResponse(Long destinationId) {
        return destinationId > 1;
    }
}
