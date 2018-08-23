package com.br.stay.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.stay.hotels.model.Hotel;
import com.br.stay.hotels.service.consume.StayLegacyService;

@RestController
public class StayHotelsServiceRetrieve {
	
	@Autowired
    private StayLegacyService stayLegacyService;

	@RequestMapping("/")
	public String SpringBootESExample() {
		return "Retrieve hotels";
	}
	
	@GetMapping("/get/hotels/avail")
	public List<Hotel> getHotelsAvailById(@RequestParam("id") String id) {
		List<Hotel> hotels ;
		
		hotels = stayLegacyService.getHotelsAvailById(id);
		
		return hotels;
	}
	
	@GetMapping("/get/hotels")
	public List<Hotel> getHotelsById(@RequestParam("id") String id) {
		List<Hotel> hotels ;
		
		hotels = stayLegacyService.getHotelsById(id);
		
		return hotels;
	}
	
}