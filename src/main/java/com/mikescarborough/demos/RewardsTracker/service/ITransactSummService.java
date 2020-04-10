package com.mikescarborough.demos.RewardsTracker.service;

import java.util.Date;
import java.util.List;

import com.mikescarborough.demos.RewardsTracker.model.CustomerRewards;
import com.mikescarborough.demos.RewardsTracker.model.TransactionSummary;
import com.mikescarborough.demos.RewardsTracker.model.RewardsReport;

/**
 * An interface that defines the functionalities which support the 
 * API endpoints related to Transaction Summaries
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
public interface ITransactSummService {

     RewardsReport getStandardReport(Date reportDate);

     List<TransactionSummary> getAllTransactSummBetweenTimes(Date start, Date end);
}
