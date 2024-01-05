package com.Airport.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Airport_details")
public class Airport {
	
	@Id
	@JsonProperty("IATA_code")
	@Column(name="IATA_code")
	private String IATACODE;
	
	@JsonProperty("airport_name")
	@Column(name="airport_name")
	private String airportName;
	
	@JsonProperty("city_name")
	@Column(name="city_name")
	private String cityName;
	


}