package com.Airport.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Airport.Entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, String>{
}

