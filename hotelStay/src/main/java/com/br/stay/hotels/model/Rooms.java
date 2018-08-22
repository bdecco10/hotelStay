package com.br.stay.hotels.model;

public class Rooms {

	private Integer roomID;
	private String categoryName;
	private Price price;

	public Rooms (){}
	
	public Rooms(Integer roomID, String categoryName, Price price) {
		super();
		this.roomID = roomID;
		this.categoryName = categoryName;
		this.price = price;
	}

	public Integer getRoomID() {
		return roomID;
	}

	public void setRoomID(Integer roomID) {
		this.roomID = roomID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	
}
