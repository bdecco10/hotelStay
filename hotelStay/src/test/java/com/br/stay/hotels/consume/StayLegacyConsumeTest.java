package com.br.stay.hotels.consume;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.br.stay.hotels.model.Hotel;
import com.br.stay.hotels.service.consume.StayLegacyService;
import com.br.stay.hotels.service.consume.StayLegacyServiceFeign;

@RunWith(MockitoJUnitRunner.Silent.class) 
public class StayLegacyConsumeTest {

	
	@InjectMocks
	StayLegacyService stayLegacyController;
	
	@InjectMocks
	StayLegacyServiceFeign stayLegacyFeignController;
	
	@Test
	public void calculateStayByHotelIdSucess() throws Exception {

		List<Hotel> hotels = stayLegacyController.getHotelsById("14");
		
		assertNotNull(hotels);
	}
	
	@Test
	public void calculateStayAvailByHotelIdSucess() throws Exception {

		List<Hotel> hotels = stayLegacyController.getHotelsAvailById("1032");
		
		assertNotNull(hotels);
	}
	
	
	@Test
	public void calculateStayByHotelIdFeignSucess() throws Exception {

		List<Hotel> hotels = stayLegacyFeignController.getHotelsByIdFeign("14");
		
		assertNotNull(hotels);
	}
	
	@Test
	public void calculateStayAvailByHotelIdFeignSucess() throws Exception {

		List<Hotel> hotels = stayLegacyFeignController.getHotelsAvailByIdFeign("1032");
		
		assertNotNull(hotels);
	}
	
}
