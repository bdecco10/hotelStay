package com.br.stay.hotels.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.stay.hotels.interfaces.IStay;
import com.br.stay.hotels.model.Hotel;
import com.br.stay.hotels.model.PriceTrip;
import com.br.stay.hotels.model.Rooms;
import com.br.stay.hotels.model.RoomsTrip;
import com.br.stay.hotels.model.Travel;
import com.br.stay.hotels.service.StayLegacyService;
import com.br.stay.hotels.utils.StayRersourceValidate;
/**
 * Classe responsavel em tratar a regra de negocio (Calculo de estadia)
 * Tadas as classes controller é obrigatorio usar a herança "StayRersourceValidate", utilizar o metodo de validação de payload
 * @author Bdecco
 *
 */
@Component
public class StayController extends StayRersourceValidate implements IStay{

	@Autowired
    private StayLegacyService stayService;
	
	/**
	 * Metodo responsavel por calcular a regra de negocio por ID do Hotel
	 * @param id
	 * @param checkin
	 * @param checkout
	 * @param amaoutAdult
	 * @param amaoutChild
	 * @return
	 * @throws Exception 
	 */
	public List<Travel> calculateStayByHotelId(String id,String checkin,String checkout,String amaoutAdult,String amaoutChild) throws Exception{
		
		validateRequest(id,checkin, checkout, amaoutAdult, amaoutChild);
		
		List<Travel> travelList = new ArrayList<>();
		List<Hotel> hotels = stayService.getHotelsById(id);

		for (Hotel hotel : hotels) {
			Travel travel = new Travel();
			travel.setId(hotel.getId());
			travel.setCityName(hotel.getCityName());
			
			for (Rooms rooms : hotel.getRooms()) {
				
				RoomsTrip roomPriece = new RoomsTrip();
				roomPriece.setPriceDetail(new PriceTrip());
				roomPriece.getPriceDetail().setPricePerDayAdult(calculateStay(rooms.getPrice().getAdult(), checkin, checkout, amaoutAdult, amaoutChild));
				roomPriece.getPriceDetail().setPricePerDayChild(calculateStay(rooms.getPrice().getChild(), checkin, checkout, amaoutAdult, amaoutChild));
				roomPriece.setTotalPrice(roomPriece.getPriceDetail().getPricePerDayAdult()+roomPriece.getPriceDetail().getPricePerDayChild());
				roomPriece.setCategoryName(rooms.getCategoryName());
				roomPriece.setRoomID(rooms.getRoomID());
				travel.getRooms().add(roomPriece);
			}
			travelList.add(travel);

		}
		return travelList;
	}
	
	/**
	 * Metodo responsavel por calcular a regra de negocio por cidade
	 * @param cityCode
	 * @param checkin
	 * @param checkout
	 * @param amaoutAdult
	 * @param amaoutChild
	 * @return
	 * @throws Exception 
	 */
	
	public List<Travel> calculateStayAllByCity(String cityCode,String checkin,String checkout,String amaoutAdult,String amaoutChild) throws Exception{
		
		validateRequest(cityCode,checkin, checkout, amaoutAdult, amaoutChild);
		
		List<Travel> travelList = new ArrayList<>();
		List<Hotel> hotels = stayService.getHotelsAvailById(cityCode);

		for (Hotel hotel : hotels) {
			Travel travel = new Travel();
			travel.setId(hotel.getId());
			travel.setCityName(hotel.getCityName());
			
			for (Rooms rooms : hotel.getRooms()) {
				
				RoomsTrip roomPriece = new RoomsTrip();
				roomPriece.setPriceDetail(new PriceTrip());
				roomPriece.getPriceDetail().setPricePerDayAdult(calculateStay(rooms.getPrice().getAdult(), checkin, checkout, amaoutAdult, amaoutChild));
				roomPriece.getPriceDetail().setPricePerDayChild(calculateStay(rooms.getPrice().getChild(), checkin, checkout, amaoutAdult, amaoutChild));
				roomPriece.setTotalPrice(roomPriece.getPriceDetail().getPricePerDayAdult()+roomPriece.getPriceDetail().getPricePerDayChild());
				roomPriece.setCategoryName(rooms.getCategoryName());
				roomPriece.setRoomID(rooms.getRoomID());
				travel.getRooms().add(roomPriece);
			}
			travelList.add(travel);

		}
		return travelList;
	}
	
	/**
	 * Metodo utilizado para calcular a taxa
	 * valueTrip/0.7  = 30% de comissão
	 * @param valueTrip
	 * @return
	 */
	public double calculateTax(double valueTrip){
		double tax = valueTrip/0.7;
		return convertToTwoDecimal(tax);

	}

	/**
	 * Metodo utilizado para calcular a estadia
	 * price * days
	 * @param people
	 * @param Checkin
	 * @param Checkout
	 * @param AmaoutAdult
	 * @param AmaoutChild
	 * @return
	 */
	public double calculateStay(double price,String Checkin,String Checkout,String AmaoutAdult,String AmaoutChild){
		long days = calculateDate(Checkin, Checkout);
		double resultAmount = price * days;
		return calculateTax(resultAmount);

	}
}