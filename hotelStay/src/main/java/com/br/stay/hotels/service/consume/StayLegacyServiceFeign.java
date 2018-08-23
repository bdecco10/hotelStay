package com.br.stay.hotels.service.consume;

import java.util.List;

import org.springframework.stereotype.Component;

import com.br.stay.hotels.enums.StayConstants;
import com.br.stay.hotels.interfaces.IStayFeign;
import com.br.stay.hotels.model.Hotel;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@Component
public class StayLegacyServiceFeign {

	public List<Hotel> getHotelsByIdFeign(String id) throws Exception {

		IStayFeign hotels = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(IStayFeign.class))
				  .logLevel(Logger.Level.FULL)
				  .target(IStayFeign.class, StayConstants.HOTELS_ID_FEIGN.getDescricao());
		
		return hotels.calculateStayByHotelId(id);
	}

	public List<Hotel> getHotelsAvailByIdFeign(String id) throws Exception {

		IStayFeign hotels = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(IStayFeign.class))
				  .logLevel(Logger.Level.FULL)
				  .target(IStayFeign.class, StayConstants.HOTELS_AVAIL_FEIGN.getDescricao());
		
		return hotels.calculateStayByHotelId(id);
	}
}