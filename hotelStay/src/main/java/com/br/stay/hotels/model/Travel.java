package com.br.stay.hotels.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class Travel {

    private Integer id;
    private String cityName;
    private List<RoomsTrip> rooms;
    private String checkin;
    private String checkout;
    
    public Travel() {}
    
	public Travel(Integer id, String cityName, List<RoomsTrip> rooms, String checkin, String checkout) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.rooms = rooms;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}



	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<RoomsTrip> getRooms() {
		if(rooms ==null){
			rooms = new ArrayList<>();
		}
		return rooms;
	}

	public void setRooms(List<RoomsTrip> rooms) {
		this.rooms = rooms;
	}
}