package com.mikescarborough.demos.RewardsTracker.repo;

import java.util.Date;
import java.util.List;

import com.mikescarborough.demos.RewardsTracker.model.TransactionSummary;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * A interface that helps setup data retrieval for 
 * Transaction Summary info
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
public interface TransactSummRepo extends CrudRepository<TransactionSummary, Integer> {

    @Query("SELECT ts FROM TransactionSummary ts WHERE ts.timestampUtc >= :transactTimerangeStart AND ts.timestampUtc < :transactTimerangeEnd")
    List<TransactionSummary> findAllBetweenTimes(@Param("transactTimerangeStart") Date dateStart,
            @Param("transactTimerangeEnd") Date dateEnd);
}