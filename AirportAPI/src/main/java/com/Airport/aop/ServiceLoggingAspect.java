package com.Airport.aop;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.Airport.Entity.Airport;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class ServiceLoggingAspect {
	
	@Before("execution(public * com.Airport.Service.AirportServiceImplementation.getAllAirports())")
	public void logFetchingAllAirports() {
		log.info("Executing getAllAirports method in the Service and fetching all airports.");
	}
	
	@Before("execution(public * com.Airport.Service.AirportServiceImplementation.getAirport(..)) && args(IATACODE)")
	public void logFetchigSpecificAirport(String IATACODE) {
		log.info("Executing getAirport method in the Service and fetching specific airport.");
	}
	
	@AfterThrowing("execution(public * com.Airport.Service.AirportServiceImplementation.getAirport(..)) && args(IATACODE)")
	public void logFetchigSpecificAirportException(String IATACODE) {
		 log.error("Requested airport does not exist for IATACODE: {}", IATACODE);
	}
	
	@Before("execution(public * com.Airport.Service.AirportServiceImplementation.createAirport(..)) && args(airport)")
	public void logCreatingAirports(Airport airport) {
		log.info("Executing createAirport method in the Service and creating airport.");
	}
	
	@AfterThrowing(value = "execution(public * com.Airport.Service.AirportServiceImplementation.createAirport(..)) && args(airport)",throwing = "e")
	public void logCreatingAirportsException(Airport airport,Exception e) {
		 log.error("Airport with IATACODE already Exists " + e.getClass());
	}
	
	@Before("execution(public * com.Airport.Service.AirportServiceImplementation.updateAirport(..)) && args(IATACODE,updatedAirport)")
	public void logUpdatingAirport(String IATACODE,Airport updatedAirport) {
		log.info("Executing updateAirport method in the Service and updating the airport.");
	}
	
	@AfterThrowing("execution(public * com.Airport.Service.AirportServiceImplementation.updateAirport(..)) && args(IATACODE,updatedAirport)")
	public void logUpdatingAirportException(String IATACODE,Airport updatedAirport) {
		log.error("Airport with IATAcode {} does not exist",IATACODE);
	}
	
	@Before("execution(public * com.Airport.Service.AirportServiceImplementation.deleteAirport(..)) && args(IATACODE)")
	public void logDeletinggAirport(String IATACODE) {
		log.info("Executing deleteAirport method in the Service and deleting the airport.");
	}
	
	@AfterThrowing("execution(public * com.Airport.Service.AirportServiceImplementation.deleteAirport(..)) && args(IATACODE)")
	public void logDeletinggAirportException(String IATACODE) {
		log.error("Airport with IATAcode {} does not exist", IATACODE);
	}
}
