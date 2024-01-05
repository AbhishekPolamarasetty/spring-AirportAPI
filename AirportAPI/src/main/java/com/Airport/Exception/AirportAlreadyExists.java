package com.Airport.Exception;

import java.util.HashMap;

//@SuppressWarnings("serial")
public class AirportAlreadyExists extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	public AirportAlreadyExists(String message) {
		super(message);
		this.message=message;
	}
	
	public HashMap<String,String> getinfo(String status){
		 HashMap<String,String> hmap= new HashMap<>();
				 hmap.put("message", message);
				 hmap.put("httpstatus", status);
		return hmap ;
	}
}
