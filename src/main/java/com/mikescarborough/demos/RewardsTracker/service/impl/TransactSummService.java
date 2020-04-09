package com.mikescarborough.demos.RewardsTracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikescarborough.demos.RewardsTracker.repo.TransactSummRepo;
import com.mikescarborough.demos.RewardsTracker.model.TransactionSummary;

@Service
public class TransactSummService implements ITransactSummService {

	@Autowired
	private TransactSummRepo transactRepo;

	@Override
	public List<TransactionSummary> getAllTransactSumm() {
		List<TransactionSummary> list = new ArrayList<>();
		return list;
	}

}
