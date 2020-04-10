package com.mikescarborough.demos.RewardsTracker.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mikescarborough.demos.RewardsTracker.model.CustomerCollation;

/**
 * A class encapsulating Reward Point report
 * data.
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
public class RewardsReport implements java.io.Serializable {
    private List<CustomerCollation> rewardsList = new ArrayList<CustomerCollation>();
    private Date beginDate = new Date();
    private Date endDate = new Date();

    public RewardsReport(List<CustomerCollation> userRewards, Date start, Date end) {
        rewardsList = userRewards;
        beginDate = start;
        endDate = end;
    }


    public List<CustomerCollation> getRewardsList() {
        return rewardsList;
    }

    public Date getBeginDate() {
            return beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

}