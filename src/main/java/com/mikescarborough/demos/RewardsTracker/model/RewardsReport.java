package com.mikescarborough.demos.RewardsTracker.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A class encapsulating Reward Point report
 * data.
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
public class RewardsReport implements java.io.Serializable {
    private Date reportBeginDate = new Date();
    private Date reportEndDate = new Date();
    private Map<Integer, CustomerCollation> collatedRewards = new HashMap<Integer, CustomerCollation>();

    public RewardsReport(Date start, Date end) {
        reportBeginDate = start;
        reportEndDate = end;
    }


    public Map<Integer, CustomerCollation> getCollatedRewards() {
        return collatedRewards;
    }

    public void addCustomerMonthRewards(CustomerMonthRewards newRewards) {
        Integer custId = new Integer(newRewards.getCustomerID());
        if (!collatedRewards.containsKey(custId)) {
            CustomerCollation newColl = new CustomerCollation();
            collatedRewards.put(custId, newColl);
        }

        CustomerCollation thisCust = collatedRewards.get(custId);
        thisCust.addCustomerMonthRewards(newRewards);
    }

    public Date getBeginDate() {
        return reportBeginDate;
    }

    public Date getEndDate() {
        return reportEndDate;
    }

}