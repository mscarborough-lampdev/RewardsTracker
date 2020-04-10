package com.mikescarborough.demos.RewardsTracker.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.mikescarborough.demos.RewardsTracker.service.impl.TransactSummService;
import com.mikescarborough.demos.RewardsTracker.model.RewardsReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * <h1>Rewards Tracker</h1> The Rewards Tracker calculates rewards points based
 * on customer transactions
 * 
 * @author Michael Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
@RestController
public class TrackerController {

	@Autowired
	private TransactSummService transactSrvc;

	@RequestMapping(path = "/",  method = {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity index() {
		HttpHeaders headers = new HttpHeaders();
		URI location;

		try {
			location = new URI("/swagger-ui.html");
			headers.setLocation(location);
		} catch (java.net.URISyntaxException excpUS) {
			System.out.println("ERROR: Could not create location URI");
		}

		return new ResponseEntity<String>
			("Welcome to the Rewards Tracker.  Please see the documentation at /swagger-ui.html", 
			headers,
			HttpStatus.OK);
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Rewards Tracker Test";
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ResponseEntity getReport() {
		RewardsReport report;
		Date reportDate = new GregorianCalendar(2020, Calendar.APRIL, 9).getTime();
		try {
			report = transactSrvc.getStandardReport(reportDate);
		} catch (org.springframework.dao.InvalidDataAccessResourceUsageException excpIDARU) {
			return new ResponseEntity<String>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RewardsReport>(report, HttpStatus.OK);
	}

	@RequestMapping(value = "/customer/{cust_id}/transaction/{num_days}", method = RequestMethod.GET)
	public float[] getTransactionAmountsByCustomerID(@PathVariable("cust_id") String customerId,
			@PathVariable("num_days") String numDays) {

		float[] retVal = { 6.99f, 51f, 52.48f, 39.01f, 128.02f, 230.45f, 12.58f };
		return retVal;
	}

}
