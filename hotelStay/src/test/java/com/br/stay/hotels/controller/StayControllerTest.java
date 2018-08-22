package com.br.stay.hotels.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.br.stay.hotels.model.Hotel;
import com.br.stay.hotels.model.Price;
import com.br.stay.hotels.model.Rooms;
import com.br.stay.hotels.model.Travel;
import com.br.stay.hotels.service.StayLegacyService;

@RunWith(MockitoJUnitRunner.Silent.class) 
public class StayControllerTest {

	
	@InjectMocks
	StayController stayController;
	
	@Mock
	public StayLegacyService stayService;
	
	
	@Test
	public void calculateStayByHotelIdSucess() throws Exception {

		List<Hotel> hotels = populateHotels();

		when(stayService.getHotelsById("14")).thenReturn(hotels);
		
		List<Travel> travelList = stayController.calculateStayByHotelId("14", "19/08/2018", "23/08/2018", "2", "1");
		
		assertNotNull(travelList);
	}
	
	@Test
	public void calculateStayByHotelAvailIdSucess() throws Exception {

		List<Hotel> hotels = populateHotels();

		when(stayService.getHotelsAvailById("14")).thenReturn(hotels);
		
		List<Travel> travelList = stayController.calculateStayAllByCity("1079", "19/08/2018", "23/08/2018", "2", "1");
		
		assertNotNull(travelList);
	}
	
	@Test(expected=Exception.class)
	public void calculateStayByHotelAvailIdError() throws Exception {

		List<Hotel> hotels = populateHotels();

		when(stayService.getHotelsAvailById("14")).thenReturn(hotels);
		
		List<Travel> travelList = stayController.calculateStayAllByCity("", "19/08/2018", "23/08/2018", "2", "1");
		
		assertNotNull(travelList);
	}
	
	@Test(expected=Exception.class)
	public void calculateStayByHotelIdError() throws Exception {

		List<Hotel> hotels = populateHotels();

		when(stayService.getHotelsById("14")).thenReturn(hotels);
		
		List<Travel> travelList = stayController.calculateStayByHotelId("", "19/08/2018", "23/08/2018", "2", "1");
		
		assertNotNull(travelList);
	}
	
	
	public List<Hotel> populateHotels() {
		
		List<Hotel> hotels = new ArrayList<>();
		Rooms rooms = new Rooms();
		Rooms rooms1 = new Rooms();
		Price price = new Price();
		Price price1 = new Price();
		
		Hotel hotel = new Hotel();
		hotel.setCityCode(1100);
		hotel.setCityName("São Paulo");
		hotel.setId(1);
		hotel.setName("Slaviero");

		rooms.setCategoryName("Luxo");
		rooms.setRoomID(10);
		
		rooms1.setCategoryName("Standard");
		rooms1.setRoomID(11);
		
		price.setAdult(1000);
		price.setAdult(500);
		
		price1.setAdult(2000);
		price1.setAdult(600);
		
		rooms.setPrice(price);
		rooms1.setPrice(price1);
		
		hotel.getRooms().add(rooms);
		hotel.getRooms().add(rooms1);
		hotels.add(hotel);
		
		return hotels;
		
	}
}
