package com.mikescarborough.demos.RewardsTracker.service.impl;

import java.util.List;

import com.mikescarborough.demos.RewardsTracker.model.TransactionSummary;
import com.mikescarborough.demos.RewardsTracker.repo.TransactSummRepo;
import com.mikescarborough.demos.RewardsTracker.service.IRewardsCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * A class managing business logic related to 
 * the calculation of Customer Reward Points
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
public class RewardsCalculatorV0001 implements IRewardsCalculator {

	public float calculateUserRewardPoints(List<TransactionSummary> transacts) {
		int total = 0;
		int rewards;

		for (TransactionSummary transact : transacts) {
			rewards = calculateTransactionRewardPoints(transact);
			total = total + rewards;
		}

		return (float)total;
	}

	private int calculateTransactionRewardPoints(TransactionSummary transact) {
		int points = 0;
		int transactTotal = (int)Math.round(Math.floor(transact.getOverallTotal()));

		if (transactTotal > 100) {
			points = points + 50;
			points = points + 2 * (transactTotal - 100);
		} else if (transactTotal > 50) {
			points = points + (transactTotal - 50);
		}

		return points;
    }
}