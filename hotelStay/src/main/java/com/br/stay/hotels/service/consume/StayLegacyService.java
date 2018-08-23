package com.br.stay.hotels.service.consume;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.br.stay.hotels.enums.StayConstants;
import com.br.stay.hotels.model.Hotel;

@Component
public class StayLegacyService {

	public List<Hotel> getHotelsAvailById(String id) {
		RestTemplate template = new RestTemplate();

		ResponseEntity<List<Hotel>> rateResponse =template.exchange(StayConstants.HOTELS_AVAIL.getDescricao(),HttpMethod.GET, null, new ParameterizedTypeReference<List<Hotel>>() {},id);

		return rateResponse.getBody();
	}

	public List<Hotel> getHotelsById(String id) {
		RestTemplate template = new RestTemplate();

		ResponseEntity<List<Hotel>> rateResponse =template.exchange(StayConstants.HOTELS_ID.getDescricao(),HttpMethod.GET, null, new ParameterizedTypeReference<List<Hotel>>() {},id);

		return rateResponse.getBody();
	}
}