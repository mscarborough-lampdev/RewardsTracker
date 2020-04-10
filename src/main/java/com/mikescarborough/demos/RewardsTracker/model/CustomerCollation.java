package com.mikescarborough.demos.RewardsTracker.model;

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
    private List<CustomerMonthRewards> custMonthRewards;
    private float rewardsTotal;

    public CustomerCollation(List<CustomerMonthRewards> monthRewards) {
        custMonthRewards = monthRewards;
        int total = 0;

        for (CustomerMonthRewards rewards : monthRewards) {
            total = total + rewards.getCustomerID();
        }
        rewardsTotal = total;
    }


    public List<CustomerMonthRewards> getCustMonthRewards() {
        return custMonthRewards;
    }

    public float getRewardsTotal() {
        return rewardsTotal;
    }
}