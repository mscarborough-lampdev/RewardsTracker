package com.mikescarborough.demos.RewardsTracker.model;

import java.util.ArrayList;
import java.util.List;
/**
 * A class representing one customers reward
 * points over one or more months.
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
public class CustomerCollation implements java.io.Serializable {
    private List<CustomerMonthRewards> custMonthRewards = new ArrayList<CustomerMonthRewards>();
    private float rewardsTotal;

    public CustomerCollation() {
        custMonthRewards = new ArrayList<CustomerMonthRewards>();
        rewardsTotal = 0.0f;
    }

    public void addCustomerMonthRewards(CustomerMonthRewards newRewards) {
        custMonthRewards.add(newRewards);
        rewardsTotal = rewardsTotal + newRewards.getRewardPoints();
    }

    public List<CustomerMonthRewards> getCustMonthRewards() {
        return custMonthRewards;
    }

    public float getRewardsTotal() {
        return rewardsTotal;
    }
}