package com.Airport.service;

import static org.junit.Assert.assertThrows;
//import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Airport.Entity.Airport;
import com.Airport.Exception.AirportAlreadyExists;
import com.Airport.Exception.AirportNotFoundException;
import com.Airport.Repository.AirportRepository;
import com.Airport.Service.AirportServiceImplementation;

@ExtendWith(MockitoExtension.class)
public class AirportServiceTest {

	@Mock
	private AirportRepository airportRepository;

	@InjectMocks
	private AirportServiceImplementation airportServiceImplementation;

	private String existingIATACODE;
	private String nonExistingIATACODE;
	private String IATACODE;
	private Airport airport;
	private Airport updatedairport;
	private Airport existingAirport;

	@BeforeEach
	public void setup() {
		existingIATACODE = "VSKP";
		nonExistingIATACODE = "MYQ";
		IATACODE = "BLR";
		airport = new Airport("BLR", "bengaluru airport", "Bengaluru");
		updatedairport = new Airport("BLR", "bengaluru International airport", "smvt bengaluru");
		existingAirport = new Airport("BLR", "bengaluru airport", "bengaluru");
	}

	@Test
	public void test_getAlldetails_success() {
		List<Airport> airport = new ArrayList<>();
		airport.add(new Airport("VSKP", "visakhapatnam international airport", "Vizag"));
		airport.add(new Airport("HYD", "Hyderabad international airport", "secunderabad"));

		when(airportRepository.findAll()).thenReturn(airport);
		assertEquals(2, airportServiceImplementation.getAllAirports().size());
	}

	@Test
	public void test_getairportByIATA() {

		Optional<Airport> expectedAirport = Optional.of(new Airport("VSKP", "ABC", "Airport ABC"));

		when(airportRepository.findById(existingIATACODE)).thenReturn(expectedAirport);
		assertEquals(existingIATACODE, airportServiceImplementation.getAirport(existingIATACODE).getIATACODE());

	}

	@Test
	public void testgetairportByIATA_NotFound() {

		when(airportRepository.findById(nonExistingIATACODE)).thenReturn(Optional.empty());
		assertThrows(AirportNotFoundException.class,
				() -> airportServiceImplementation.getAirport(nonExistingIATACODE));
	}

	@Test
	public void test_createAirports() {

		when(airportRepository.save(airport)).thenReturn(airport);
		assertEquals(airport, airportServiceImplementation.createAirport(airport));

	}

	@Test
	public void testcreateAirports_AlreadyExists() {

		when(airportRepository.existsById(airport.getIATACODE())).thenReturn(true);
		assertThrows(AirportAlreadyExists.class, () -> airportServiceImplementation.createAirport(airport));
	}

	@Test
	public void test_deleteAirports() {

		when(airportRepository.existsById(IATACODE)).thenReturn(true);

		assertEquals("Airport deleted successfully", airportServiceImplementation.deleteAirport(IATACODE));
	}

	@Test
	public void testdeleteAirports_NotFound() {

		when(airportRepository.existsById(nonExistingIATACODE)).thenReturn(false);
		assertThrows(AirportNotFoundException.class,
				() -> airportServiceImplementation.deleteAirport(nonExistingIATACODE));
	}

	@Test
	public void test_updateAirpots() {

		Optional<Airport> optionalExistingAirport = Optional.of(existingAirport);

		when(airportRepository.findById(IATACODE)).thenReturn(optionalExistingAirport);
		Airport result = airportServiceImplementation.updateAirport(IATACODE, updatedairport);
		assertEquals(updatedairport, result);

	}

	@Test
	public void testupdateAirpots_NotFound() {

		when(airportRepository.findById(nonExistingIATACODE)).thenReturn(Optional.empty());
		assertThrows(AirportNotFoundException.class,
				() -> airportServiceImplementation.updateAirport(nonExistingIATACODE, updatedairport));
	}

}
