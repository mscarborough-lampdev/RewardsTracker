package com.mikescarborough.demos.RewardsTracker.model;

/**
 * A class representing one customers reward
 * points.
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
public class CustomerRewards implements java.io.Serializable {
    private int customerID;
    private float rewardPoints;

    public CustomerRewards(int id, float points) {
        customerID = id;
        rewardPoints = points;
    }


    public int getCustomerID() {
        return customerID;
    }

    public float getRewardPoints() {
            return rewardPoints;
    }

}