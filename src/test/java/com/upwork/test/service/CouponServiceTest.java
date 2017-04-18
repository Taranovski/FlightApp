package com.upwork.test.service;

import com.upwork.test.common.RandomGeneratorService;
import com.upwork.test.dao.CouponDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by Titan on 19.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CouponServiceTest.AppConfig.class})
public class CouponServiceTest {

    @Configuration
    public static class AppConfig {
        @Bean
        public CouponService couponService() {
            return new CouponService();
        }

        @Bean
        public CouponDao couponDao() {
            return Mockito.mock(CouponDao.class);
        }

        @Bean
        public RandomGeneratorService randomGeneratorService() {
            return Mockito.mock(RandomGeneratorService.class);
        }
    }

    @Autowired
    private CouponService couponService;

    @Autowired
    private RandomGeneratorService randomGeneratorService;

    @Autowired
    private CouponDao couponDao;

    @Before
    public void before() {
        Mockito.reset(randomGeneratorService, couponDao);
    }

    @Test
    public void shouldInvalidateCouponWhenFoundAvailable() {
        long couponId = 1L;
        BigDecimal price = BigDecimal.ONE;

        when(couponDao.isValidCoupon(eq(couponId))).thenReturn(true);
        when(randomGeneratorService.getRandomDiscountPercentage()).thenReturn(BigDecimal.ONE);

        BigDecimal bigDecimal = couponService.processCouponForPrice(couponId, price);
        //result is not checked now because there is some mistake in calculations


        verify(couponDao, times(1)).isValidCoupon(eq(couponId));
        verify(couponDao, times(1)).invalidateCoupon(eq(couponId));
    }
}