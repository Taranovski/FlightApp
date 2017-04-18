package com.upwork.test.controller;

import com.upwork.test.service.BaggageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Titan on 18.04.2017.
 */
@RestController
@RequestMapping("/baggage")
public class BaggageController {

    @Autowired
    private BaggageService baggageService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "/checkIn")
    public Boolean checkInBaggage(
            @RequestParam("destinationId") Long destinationId,
            @RequestParam("baggageId") String baggageId
    ) {
        return baggageService.checkIn(destinationId, baggageId);
    }


}
