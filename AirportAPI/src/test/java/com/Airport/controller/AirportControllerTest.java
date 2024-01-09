package com.Airport.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import com.Airport.Controller.AirportController;
import com.Airport.Entity.Airport;
import com.Airport.Exception.AirportAlreadyExists;
import com.Airport.Exception.AirportNotFoundException;
import com.Airport.Service.AirportService;

@ExtendWith(SpringExtension.class)
public class AirportControllerTest {
	
	@Mock
	private AirportService airportService;
	
	@InjectMocks
	private AirportController airportController;
	
	@Test
	public void getAllAirportDetails_success() throws Exception {
		Airport airport1 = new Airport();
		airport1.setIATACODE("HYD");
		airport1.setAirportName("hyderabad international airport");
		airport1.setCityName("Hyderabad");
		
		Airport airport2 = new Airport();
		airport2.setIATACODE("BLR");
		airport2.setAirportName("Bengaluru international airport");
		airport2.setCityName("Bangalore");
		
		List <Airport> airportList =  new ArrayList<>();
		airportList.add(airport1);
		airportList.add(airport2);
		
		when(airportService.getAllAirports()).thenReturn(airportList);
		
		List <Airport> result = airportController.getAllAirportDetails();
		assertEquals(airportList, result);
		assertEquals(2,result.size());	
	}
	
	@Test
    public void testGetAirportDetails_ValidIATACode() throws AirportNotFoundException {
        String validIATACode = "VSKP";
        Airport expectedAirport = new Airport("VSKP","ABC", "Airport ABC");

        when(airportService.getAirport(validIATACode)).thenReturn(expectedAirport);

        ResponseEntity<?> responseEntity = airportController.getAirportDetails(validIATACode);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedAirport, responseEntity.getBody());

    }
	
	@Test
    public void testGetAirportDetails_InvalidIATACode() throws AirportNotFoundException {
        String invalidIATACode = "INVALID";

        when(airportService.getAirport(invalidIATACode)).thenThrow(new AirportNotFoundException("Airport not found"));

        ResponseEntity<?> responseEntity = airportController.getAirportDetails(invalidIATACode);

        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
	
	@Test
    public void testCreateAirportDetailsSuccess() {
        Airport airport = new Airport("VSKP","ABC", "Airport ABC");
        when(airportService.createAirport(airport)).thenReturn("Success");
        ResponseEntity<?> response = airportController.createAirportDetails(airport);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Airport created successfully", response.getBody());
    }
	
	  @Test
	    public void testCreateAirportDetails_Conflict() {

	        Airport airport = new Airport("VSKP","ABC", "Airport ABC");
	        when(airportService.createAirport(airport)).thenThrow(new AirportAlreadyExists("Airport already exists"));

	   
	        ResponseEntity<?> response = airportController.createAirportDetails(airport);
	        assertEquals(HttpStatus.CONFLICT,response.getStatusCode());
	
	    }

}

    
