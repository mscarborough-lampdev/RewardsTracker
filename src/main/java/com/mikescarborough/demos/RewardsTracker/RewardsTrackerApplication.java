package com.mikescarborough.demos.RewardsTracker;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * An application that helps calculate summary information
 * about customer rewards
 *
 * @author  Mike Scarborough
 * @version 1.0
 * @since 2020-04-07
 */
@SpringBootApplication
public class RewardsTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardsTrackerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Available beans:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}