package com.br.stay.hotels.model;

public class Price {

	private double adult;
	private double child;

	public Price (){}
	
	public Price(double adult, double child) {
		super();
		this.adult = adult;
		this.child = child;
	}

	public double getAdult() {
		return adult;
	}

	public void setAdult(double adult) {
		this.adult = adult;
	}

	public double getChild() {
		return child;
	}

	public void setChild(double child) {
		this.child = child;
	}

	

}
