package com.upwork.test.common;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by Titan on 18.04.2017.
 */
@Component
public class RandomGeneratorService {

    private Random random = new Random();

    public BigDecimal getRandomDiscountPercentage() {
        return new BigDecimal(random.nextInt(20));
    }

    public Long getRandomSmallLong(){
        return (long) random.nextInt(10);
    }
}
