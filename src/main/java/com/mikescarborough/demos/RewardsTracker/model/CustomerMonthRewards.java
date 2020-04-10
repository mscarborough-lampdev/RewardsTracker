package com.mikescarborough.demos.RewardsTracker.model;

/**
 * A class representing one customers reward
 * points for a single month.
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
public class CustomerMonthRewards implements java.io.Serializable {
    private int customerID;
    private float rewardPoints;
    private int monthNum;
    private int year;

    public CustomerMonthRewards(int id, float points, int month, int year) {
        customerID = id;
        rewardPoints = points;
        monthNum = month;
        this.year = year;
    }


    public int getCustomerID() {
        return customerID;
    }

    public float getRewardPoints() {
        return rewardPoints;
    }

    public float getMonthNum() {
        return monthNum;
    }

    public float getYear() {
        return year;
    }


}