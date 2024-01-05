package com.Airport.Exception;

import java.util.HashMap;

//@SuppressWarnings("serial")
public class AirportNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String errorMsg ;	
    
	public AirportNotFoundException(String message) {
		super(message);
		this.errorMsg=message;
	}
	
	public HashMap<String,String> getMes(String status){
		 HashMap<String,String> hmap= new HashMap<>();
				 hmap.put("message", errorMsg);
				 hmap.put("httpstatus", status);
		return hmap ;
	}
	
}