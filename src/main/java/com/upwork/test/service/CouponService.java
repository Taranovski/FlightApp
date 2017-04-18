package com.upwork.test.service;

import com.upwork.test.common.RandomGeneratorService;
import com.upwork.test.dao.CouponDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by Titan on 18.04.2017.
 */
@Component
public class CouponService {

    private final MathContext mathContext = new MathContext(2, RoundingMode.HALF_EVEN);
    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");

    @Autowired
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    private CouponDao couponDao;

    public BigDecimal processCouponForPrice(Long couponId, BigDecimal price) {

        if (couponDao.isValidCoupon(couponId)) {
            couponDao.invalidateCoupon(couponId);

            return getPriceWithDiscount(price);
        } else {
            return price;
        }

    }

    private BigDecimal getPriceWithDiscount(BigDecimal price) {
        //somewhere here I've lost the fractions...
        BigDecimal discount = randomGeneratorService.getRandomDiscountPercentage().divide(ONE_HUNDRED, mathContext);
        BigDecimal priceCoefficient = BigDecimal.ONE.subtract(discount, mathContext);
        return price.multiply(priceCoefficient, mathContext);
    }

}
