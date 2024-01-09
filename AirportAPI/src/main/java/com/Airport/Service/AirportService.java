package com.Airport.Service;

import java.util.List;

import com.Airport.Entity.Airport;
import com.Airport.Exception.AirportAlreadyExists;
import com.Airport.Exception.AirportNotFoundException;

public interface AirportService {
	public Airport createAirport(Airport airport) throws AirportAlreadyExists;
	public Airport updateAirport(String IATACODE, Airport airport) throws AirportNotFoundException ;
	public String deleteAirport(String airportIATACODE)throws AirportNotFoundException;
	public Airport getAirport(String airportIATACODE) throws AirportNotFoundException;
	public List<Airport> getAllAirports();
}

