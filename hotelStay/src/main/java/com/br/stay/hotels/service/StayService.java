package com.br.stay.hotels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.stay.hotels.controller.StayController;
import com.br.stay.hotels.model.Hotel;
import com.br.stay.hotels.model.Travel;

@RestController
public class StayService {
	
	@Autowired
    private StayController stayController;
	
	@Autowired
    private StayLegacyService stayService;

	@RequestMapping("/")
	public String SpringBootESExample() {
		return "SpringBoot";
	}
	
	@GetMapping("/get/hotels/avail")
	public List<Hotel> getHotelsAvailById(@RequestParam("id") String id) {
		List<Hotel> hotels ;
		
		hotels = stayService.getHotelsAvailById(id);
		
		return hotels;
	}
	
	@GetMapping("/get/hotels")
	public List<Hotel> getHotelsById(@RequestParam("id") String id) {
		List<Hotel> hotels ;
		
		hotels = stayService.getHotelsById(id);
		
		return hotels;
	}
	
	//Eu particularmente criaria como POST, acho mais facil manipular o objeto nesse caso,
	//Porem como na documentação esta escrito para criar como get, estou seguindo a mesma!.
	@GetMapping("/get/allByCity")
	public List<Travel> getAllByCity(@RequestParam("cityCode") String cityCode,@RequestParam("checkin") String checkin,
			@RequestParam("checkout") String checkout,@RequestParam("amountAdult") String amountAdult,
			@RequestParam("amountChild") String amountChild) throws Exception{
		
		List<Travel> travel = stayController.calculateStayAllByCity(cityCode, checkin,checkout,amountAdult,amountChild);
		
		return travel;
	}
	
	//Eu particularmente criaria como POST, acho mais facil manipular o objeto nesse caso,
	//Porem como na documentação esta escrito para criar como get, estou seguindo a mesma!.
	@GetMapping("/get/byHotelId")
	public List<Travel> getByHotelId(@RequestParam("id") String id,@RequestParam("checkin") String checkin,
			@RequestParam("checkout") String checkout,@RequestParam("amountAdult") String amountAdult,
			@RequestParam("amountChild") String amountChild) throws Exception {
		
		List<Travel> travel = stayController.calculateStayByHotelId(id, checkin,checkout,amountAdult,amountChild);
		
		return travel;
	}
}