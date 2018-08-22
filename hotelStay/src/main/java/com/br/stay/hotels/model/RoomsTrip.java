package com.br.stay.hotels.model;

public class RoomsTrip {

	private Integer roomID;
	private String categoryName;
	private PriceTrip priceDetail;
	private double totalPrice;

	public RoomsTrip (){}
	
	public RoomsTrip(Integer roomID, String categoryName, PriceTrip priceDetail, double totalPrice) {
		super();
		this.roomID = roomID;
		this.categoryName = categoryName;
		this.priceDetail = priceDetail;
		this.totalPrice = totalPrice;
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

	public PriceTrip getPriceDetail() {
		return priceDetail;
	}

	public void setPriceDetail(PriceTrip priceDetail) {
		this.priceDetail = priceDetail;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
