package com.mikescarborough.demos.RewardsTracker.repo;

import org.springframework.data.repository.CrudRepository;

import com.mikescarborough.demos.RewardsTracker.model.TransactionSummary;

public interface TransactSummRepo extends CrudRepository<TransactionSummary, Integer> {

}