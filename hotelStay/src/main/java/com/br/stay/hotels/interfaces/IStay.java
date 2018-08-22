package com.br.stay.hotels.interfaces;

import java.util.List;

import com.br.stay.hotels.model.Travel;
/**
 * Interface Utilizada para desacoplamento, caso alguma outra classe precise validar de forma diferente o calculo
 * Conceito de polimorfismo
 * @author Bdecco
 *
 */


public interface IStay {

	public List<Travel> calculateStayByHotelId(String id,String checkin,String checkout,String amaoutAdult,String amaoutChild) throws Exception;
	public List<Travel> calculateStayAllByCity(String cityCode,String checkin,String checkout,String amaoutAdult,String amaoutChild)throws Exception;
	public double calculateTax(double valueTrip);
	public double calculateStay(double price,String Checkin,String Checkout,String AmaoutAdult,String AmaoutChild);
}
