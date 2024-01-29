spackage com.Airport.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Airport.Entity.Airport;
import com.Airport.Exception.AirportAlreadyExists;
import com.Airport.Exception.AirportNotFoundException;
import com.Airport.Repository.AirportRepository;




@Service
public class AirportServiceImplementation implements AirportService{ 
	
//	private static final Logger logger = LoggerFactory.getLogger(AirportServiceImplementation.class);
	
	@Autowired
	private AirportRepository airportRepository;

	
	@Override
	public List <Airport> getAllAirports(){
//		log.info("Fetching all airports from the repository.");
		return airportRepository.findAll();
	}
	
	@Override
	public Airport getAirport(String IATACODE) {
	
			if (!airportRepository.findById(IATACODE).isEmpty()) {
//				log.info("Fetching specific airport from the repository.");
				return airportRepository.findById(IATACODE).get();
		    }
			else {
//		        log.error("Requested airport does not exist for IATACODE: {}", IATACODE);
		        throw new AirportNotFoundException("Requested airport does not exist");
			}
		   
	   
	}

	@Override
	public Airport createAirport(Airport airport) {
	  
	        if (!airportRepository.existsById(airport.getIATACODE())) {
//	        	log.info("Creating airport...");
		        airportRepository.save(airport);
		        return airport;
	        }

	        else {
//	        	 log.error("Airport is already Exists");
	             throw new AirportAlreadyExists("Airport with IATA code already exists");
	        }
	} 
	

	@Override
	public Airport updateAirport(String IATACode, Airport updatedAirport) {
	    Optional <Airport> optionalExistingAirport = airportRepository.findById(IATACode);
 
	    if (optionalExistingAirport.isPresent()) {
//	    	  log.info("Updating specific airport from the repository.");
	        Airport existingAirport = optionalExistingAirport.get();
	        
	        existingAirport.setAirportName(updatedAirport.getAirportName());
	        existingAirport.setCityName(updatedAirport.getCityName());
	      
	        airportRepository.save(existingAirport);
	        return updatedAirport;
	    } else {
//	    	log.error("Airport with IATA code does not exist");
	        throw new AirportNotFoundException("Airport with IATA code does not exist");
	    }
	}

	@Override
	public String deleteAirport(String airportIATACODE) {
		
	        if (airportRepository.existsById(airportIATACODE)) {
//	            log.info("Deleting specific airport from the repository.");
	            airportRepository.deleteById(airportIATACODE); 
	            return "Airport deleted successfully";
	        } 
	        else {
//	            log.error("Airport with IATA code does not exist");
	            throw new AirportNotFoundException("Airport with IATA code does not exist");
	        }
	 
	}	
}