package com.upwork.test.dao;

import com.upwork.test.common.RandomGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Titan on 18.04.2017.
 */
@Component
public class CouponDao {

    @Autowired
    private RandomGeneratorService randomGeneratorService;

    private Set<Long> validCoupons = new HashSet<Long>();

    @PostConstruct
    public void init() {
        for (int i = 0; i < 5; i++) {
            validCoupons.add(randomGeneratorService.getRandomSmallLong());
        }
    }

    public boolean isValidCoupon(Long couponId) {
        return validCoupons.contains(couponId);
    }

    public void invalidateCoupon(Long couponId) {
        validCoupons.remove(couponId);
    }
}
