package com.mikescarborough.demos.RewardsTracker;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import com.mikescarborough.demos.RewardsTracker.service.IRewardsCalculator;
import com.mikescarborough.demos.RewardsTracker.service.impl.RewardsCalculatorV0001;

@Configuration
public class RewardsCalcConfig {
 
    @Bean
    @ConditionalOnProperty(name = "rewardscalculator.version", havingValue = "0001", matchIfMissing = true)
    public IRewardsCalculator calcV0001() {
        return new RewardsCalculatorV0001();
    }
 
/*
    @Bean
    @ConditionalOnProperty(name = "rewardscalculator.version", havingValue = "0001", matchIfMissing = true)
    public IRewardsCalculator calcV0001() {
        return new RewardsCalculatorV0001();
    }
*/
}