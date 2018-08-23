package com.br.stay.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.stay.hotels.controller.StayControllerFeign;
import com.br.stay.hotels.model.Travel;

@RestController
public class StayHotelsServiceFeign {
	
	@Autowired
    private StayControllerFeign stayControllerFeign;
	
	//Metodo realiza a mesma regra que os de cima porem usando o Feign para consumir o serviço, melhor performace
	@GetMapping("/get/feign/byHotelId")
	public List<Travel> getByHotelIdFeign(@RequestParam("id") String id,@RequestParam("checkin") String checkin,
			@RequestParam("checkout") String checkout,@RequestParam("amountAdult") String amountAdult,
			@RequestParam("amountChild") String amountChild) throws Exception {
		
		List<Travel> travel = stayControllerFeign.calculateStayByHotelIdFeign(id, checkin,checkout,amountAdult,amountChild);
		
		return travel;
	}
	//Metodo realiza a mesma regra que os de cima porem usando o Feign para consumir o serviço, melhor performace
	@GetMapping("/get/feign/byHotelAvailId")
	public List<Travel> getByHotelAvailIdFeign(@RequestParam("id") String id,@RequestParam("checkin") String checkin,
			@RequestParam("checkout") String checkout,@RequestParam("amountAdult") String amountAdult,
			@RequestParam("amountChild") String amountChild) throws Exception {
		
		List<Travel> travel = stayControllerFeign.calculateStayAllByCityFeign(id, checkin,checkout,amountAdult,amountChild);
		
		return travel;
	}
}