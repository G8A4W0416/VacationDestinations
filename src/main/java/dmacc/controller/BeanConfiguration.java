package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Trip;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Trip trip() {
		Trip bean = new Trip();
		return bean;
	}
}
