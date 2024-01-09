package com.Airport.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
//import static org.mockito.Mockito.when;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Airport.Entity.Airport;
import com.Airport.Exception.AirportNotFoundException;
import com.Airport.Repository.AirportRepository;
import com.Airport.Service.AirportServiceImplementation;

@ExtendWith(SpringExtension.class)
public class AirportServiceTest {
	
	@Mock
	private AirportRepository airportRepository;
	
	@InjectMocks
	private AirportServiceImplementation airportServiceImplementation;
	
	@Test
	public void test_getAlldetails_success() {
		List<Airport> airport = new ArrayList<>();
		airport.add(new Airport("VSKP","visakhapatnam international airport","Vizag"));
		airport.add(new Airport("HYD","Hyderabad international airport","secunderabad"));
		when(airportRepository.findAll()).thenReturn(airport);
		assertEquals(2,airportServiceImplementation.getAllAirports().size());
	}
	
	@Test
	public void test_getairportByIATA() {
		Optional<Airport> expectedAirport = Optional.of(new Airport("VSKP","ABC", "Airport ABC"));
		String IATACODE = "VSKP";
		when(airportRepository.findById(IATACODE)).thenReturn(expectedAirport);
		assertEquals(IATACODE,airportServiceImplementation.getAirport(IATACODE).getIATACODE());
	}
	@Test
	public void test_createAirports() {
		Airport airport = new Airport("BLR","bengaluru airport","Bengaluru");
		
		when(airportRepository.save(airport)).thenReturn(airport);
		assertEquals("Success",airportServiceImplementation.createAirport(airport));
	}
	
	@Test
	public void test_deleteAirports() {
		Airport airport = new Airport("BLR","bengaluru airport","Bengaluru");
		String IATACODE = "BLR";
		
		doThrow(new AirportNotFoundException("Airport with IATA code does not exist")).when(airportRepository).deleteById("IATACODE");

		assertEquals("Airport deleted successfully",airportServiceImplementation.deleteAirport(IATACODE));
	}

}
