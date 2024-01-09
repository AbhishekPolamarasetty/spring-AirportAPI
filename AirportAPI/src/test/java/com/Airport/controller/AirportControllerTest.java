package com.Airport.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
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
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
public class AirportControllerTest {
	
	@Mock
	private AirportService airportService;
	
	@InjectMocks
	private AirportController airportController;

    @Test
	public void test_getAllAirports() {
    	List<Airport> airport = new ArrayList <Airport>();
    	airport.add(new Airport("VSKP","Visakhapatnam international airport","vizag"));
    	when(airportService.getAllAirports()).thenReturn(airport);
    	
    	List <Airport> result = airportController.getAllAirportDetails();
    	assertEquals(airport,result);
		
	}
//	
    
	@Test
    public void testGetAirportDetails_ValidIATACode() throws AirportNotFoundException {
        String validIATACode = "VSKP";
        Airport expectedAirport = new Airport("VSKP","ABC", "Airport ABC");

        when(airportService.getAirport(validIATACode)).thenReturn(expectedAirport);

        ResponseEntity<?> responseEntity = airportController.getAirportDetails(validIATACode);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedAirport, responseEntity.getBody());

    }
//	
	@Test
    public void testGetAirportDetails_InvalidIATACode() throws AirportNotFoundException {
        String invalidIATACode = "INVALID";

        when(airportService.getAirport(invalidIATACode)).thenThrow(new AirportNotFoundException("Airport not found"));


        // Asserting that the response status code should be NOT_FOUND after handling the exception
        ResponseEntity<?> responseEntity = airportController.getAirportDetails(invalidIATACode);
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());

//        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
//	
	@Test
    public void testCreateAirportDetailsSuccess() {
        Airport airport = new Airport("VSKP","ABC", "Airport ABC");
        when(airportService.createAirport(airport)).thenReturn(airport);
        ResponseEntity<?> response = airportController.createAirportDetails(airport);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Airport created successfully", response.getBody());
    }
//	
	  @Test
	    public void testCreateAirportDetails_Conflict() {

	        Airport airport = new Airport("VSKP","ABC", "Airport ABC");
	        when(airportService.createAirport(airport)).thenThrow(new AirportAlreadyExists("Airport already exists"));

	   
	        ResponseEntity<?> response = airportController.createAirportDetails(airport);
	        assertEquals(HttpStatus.CONFLICT,response.getStatusCode());
	
	    }
	  @Test
	  public void test_updateAirportdetails() {
		  String IATACODE = "VSKP";
		  Airport airport = new Airport("VSKP","ABC", "Airport ABC");

		  
		  when(airportService.updateAirport(IATACODE, airport)).thenReturn(airport);
		  ResponseEntity<?> response = airportController.updateAirportDetails(IATACODE,airport);
		  assertEquals(HttpStatus.OK,response.getStatusCode());
	  }
	  @Test
	    public void test_updateAirportDetails_NotFound() {
		    String IATACODE = "VSKP";
	        Airport airport = new Airport("VSKP","ABC", "Airport ABC");
	        when(airportService.updateAirport(IATACODE,airport)).thenThrow(new AirportNotFoundException("Airport not found"));

	   
	        ResponseEntity<?> response = airportController.updateAirportDetails(IATACODE, airport);
	        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	
	    }
	  @Test
	  public void test_deleteAirport() {
		  String IATACODE = "VSKP";
//		  Airport airport = new Airport("VSKP","ABC", "Airport ABC");
		  when(airportService.deleteAirport(IATACODE)).thenReturn("Airport Deleted SUccessfully");
		  
		  ResponseEntity <?> response = airportController.deleteAirportDetails(IATACODE);
		  assertEquals(HttpStatus.OK,response.getStatusCode());
	  }
	  @Test
	  public void test_deleteAirportNotFound() {
		  String IATACODE = "VSKP";
		  when(airportService.deleteAirport(IATACODE)).thenThrow(new AirportNotFoundException("Airport not found"));
		  
		  ResponseEntity<?> response = airportController.deleteAirportDetails(IATACODE);
		  assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
	  }
	
}



    
