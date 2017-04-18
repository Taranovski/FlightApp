package com.upwork.test.controller;

import com.upwork.test.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * Created by Titan on 18.04.2017.
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "/use")
    public BigDecimal useCoupon(
            @RequestParam("couponId") Long couponId,
            @RequestParam("price") BigDecimal price
    ) {
        return couponService.processCouponForPrice(couponId, price);
    }
}
