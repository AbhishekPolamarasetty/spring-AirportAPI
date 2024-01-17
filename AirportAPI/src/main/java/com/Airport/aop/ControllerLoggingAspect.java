package com.Airport.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.Airport.Entity.Airport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ControllerLoggingAspect {
	
	@Before("execution(public * com.Airport.Controller.AirportController.getAllAirportDetails())")
	public void logFetchingAirportDetails() {
		log.info("Executing getAllAirportDetails method in the Controller and fetching all airports.");
	}
	
	@Before("execution( public * com.Airport.Controller.AirportController.createAirportDetails(..)) && args(airport)")
	public void logCreatingAirport(Airport airport) {
		log.info("Executing createAirportDetails method in the Controller and Creating airport.");
	}
	
	@Before("execution(public * com.Airport.Controller.AirportController.getAirportDetails(..)) && args(IATACODE)")
	public void logFetchingSpecificAirport(String IATACODE) {
		log.info("Executing getAirportDetails method in the Controller and fetching specific airport.");
	}
	
	@Before("execution(public * com.Airport.Controller.AirportController.updateAirportDetails(..)) && args(IATACODE,airport)")
	public void logUpdatingAirports(String IATACODE,Airport airport) {
		log.info("Executing updateAirportDetails method in the Controller and updating specific airport.");
	}
	
	@Before("execution(public * com.Airport.Controller.AirportController.deleteAirportDetails(..)) && args(IATACODE)")
	public void logDeletingSpecificAirport(String IATACODE) {
		log.info("Executing deleteAirportDetails method in the Controller and deleting specific airport.");
	}
}
