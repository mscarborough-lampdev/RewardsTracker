package com.mikescarborough.demos.RewardsTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* <h1>Rewards Tracker</h1>
* The Rewards Tracker calculates rewards points based on 
* customer transactions
* 
* @author  Michael Scarborough
* @version 1.0
* @since   2020-04-07
*/
@RestController
public class TrackerController {

//	@Autowired
//	private TransactionSummaryRepository transactionSummaryRepo;

	@RequestMapping("/")
	public String index() {
		return "Welcome to the Rewards Tracker.";
	}


	@RequestMapping("/test")
	public String test() {
		return "Rewards Tracker Test";
	}

    @RequestMapping(value = "/customer/{cust_id}/transaction/{num_days}", method = RequestMethod.GET)
    public float[] getTransactionAmountsByCustomerID(
		@PathVariable("cust_id") String customerId, 
		@PathVariable("num_days") String numDays
	) {

		float[] retVal = {6.99f, 51f, 52.48f, 39.01f, 128.02f, 230.45f, 12.58f};
		return retVal;
	}

}
