package com.mikescarborough.demos.RewardsTracker;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TrackerController {

	@RequestMapping("/")
	public String index() {
		return "Welcome to the Rewards Tracker.";
	}


	@RequestMapping("/test")
	public String test() {
		return "Rewards Tracker Test";
	}

}
