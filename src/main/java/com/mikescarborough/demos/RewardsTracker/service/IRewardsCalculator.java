package com.mikescarborough.demos.RewardsTracker.service;

import java.util.List;

import com.mikescarborough.demos.RewardsTracker.model.TransactionSummary;

/**
 * An interface that defines the functionalities which support the 
 * API endpoints related to customer reward points
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
public interface IRewardsCalculator {
     float calculateUserRewardPoints(List<TransactionSummary> transacts);
}
