package com.mikescarborough.demos.RewardsTracker.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.mikescarborough.demos.RewardsTracker.model.CustomerCollation;
import com.mikescarborough.demos.RewardsTracker.model.CustomerMonthRewards;
import com.mikescarborough.demos.RewardsTracker.model.RewardsReport;
import com.mikescarborough.demos.RewardsTracker.model.TransactionSummary;
import com.mikescarborough.demos.RewardsTracker.repo.TransactSummRepo;
import com.mikescarborough.demos.RewardsTracker.service.IRewardsCalculator;
import com.mikescarborough.demos.RewardsTracker.service.ITransactSummService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * A class managing business logic related to 
 * Transaction Summary info
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
@Service
public class TransactSummService implements ITransactSummService {

	@Autowired
	private TransactSummRepo transactRepo;

	private IRewardsCalculator rewardsCalc = new RewardsCalculatorV0001();

	@Override
	public RewardsReport getStandardReport(Date reportDate) {
		return getPrior3CalMonthReport(reportDate);
	}

	protected RewardsReport getPrior3CalMonthReport(Date reportDate) {
		int NUM_MONTHS = 3;
		List<TransactionSummary> transactList, userTransactList;
		List<CustomerMonthRewards> custPoints = new ArrayList<CustomerMonthRewards>();
		RewardsReport report;

		Date beginDate = getFirstDayOfPrecedingMonth(reportDate, NUM_MONTHS);
		Date endDate = getFirstDayOfPrecedingMonth(reportDate, 2);

		System.out.println("Begin: " + beginDate.toString() + "  End: " + endDate.toString() + "  Report: " + reportDate.toString());

		transactList = getAllTransactSummBetweenTimes(beginDate, endDate);

		Map<Integer, List<TransactionSummary>> userSummaries = separateTransactionSummariesByUser(transactList);

		Set<Integer> userList = userSummaries.keySet();
		for (Integer currCust : userList) {
			userTransactList = userSummaries.get(currCust);
			int rewardPoints = Math.round(rewardsCalc.calculateUserRewardPoints(userTransactList));

			Calendar calendar = Calendar.getInstance();
			calendar.setTime(beginDate);
			CustomerMonthRewards thisRewards = new CustomerMonthRewards(currCust.intValue(), (float) rewardPoints, calendar.get(Calendar.MONTH),  calendar.get(Calendar.YEAR));
			custPoints.add(thisRewards);
			System.out.println("User #" + currCust + "  Rewards = " + rewardPoints);
		}
		CustomerCollation custMultiMonths = new CustomerCollation(custPoints);
		report = new RewardsReport(custMultiMonths, beginDate, endDate);

		return report;
	}

	@Override
	public List<TransactionSummary> getAllTransactSummBetweenTimes(Date start, Date end) {
		List<TransactionSummary> list;
		list = transactRepo.findAllBetweenTimes(start, end);
		return list;
	}

	private Date getFirstDayOfPrecedingMonth(Date referenceDate, int numOfMonthsAgo) {
		Calendar calRep = Calendar.getInstance();
		calRep.setTime(referenceDate);
		int currMonth = calRep.get(Calendar.MONTH);
		int currYear = calRep.get(Calendar.YEAR);
		int numYears = (int)Math.round(Math.floor(numOfMonthsAgo / 12.0));
		int numOfMonthsForCalc = numOfMonthsAgo % 12;

		int reportBeginMonth = (((currMonth + 12) - numOfMonthsForCalc) % 12);
		Calendar cal = Calendar.getInstance();
		cal.set((currYear - numYears), reportBeginMonth, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
		Date retVal = cal.getTime();

		return retVal;
	}

	private Map<Integer, List<TransactionSummary>> separateTransactionSummariesByUser(List<TransactionSummary> list) {
		Map<Integer, List<TransactionSummary>> userSumm = new HashMap<Integer, List<TransactionSummary>>();
		List<TransactionSummary> map, userList;
		Integer custId;

		System.out.println("Begin list  (size = " + list.size() + "):");
		for (TransactionSummary transact : list) {
			custId = new Integer(transact.getCustId());
			if (!userSumm.containsKey(custId)) {
				map = new ArrayList<TransactionSummary>();
				userSumm.put(custId, map);
			}
			userList = userSumm.get(custId);
			userList.add(transact);
			System.out.println("Cust #" + transact.getCustId() + "  transact: " + transact.getId() + "  Tot=" + transact.getOverallTotal());
		}

		return userSumm;
	}
}
