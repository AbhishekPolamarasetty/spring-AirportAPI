package com.Airport.Interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class AirportInterceptorConfig extends WebMvcConfigurationSupport {
	@Autowired
	AirportInterceptor airportInterceptor;
	
	 @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(airportInterceptor);
	   }
}
