package com.br.stay.hotels.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe responsavel por validar todos os payloads
 * Validei apenas um cenario para esse teste, visto que nao é a ideial perder muito tempo para esse teste
 * Deveria existir aqui a validação da formatação da data e etc..
 * @author Bdecco
 *
 */
public abstract class StayRersourceValidate {

	public void validateRequest(String id,String checkin,String checkout,String amaoutAdult,String amaoutChild) throws Exception{
		
		if(id.isEmpty()||checkin.isEmpty()||checkout.isEmpty()||amaoutAdult.isEmpty()||amaoutChild.isEmpty())
			throw new Exception("Favor preencher os parametros corretamente");
		
	}
	
	/**
	 * Metodo utilziado para calcular a quantidade de dias 
	 * @param Checkin
	 * @param Checkout
	 * @return
	 */
	public long calculateDate(String Checkin,String Checkout){
		long dt = 0;
		try {
			DateFormat df = new SimpleDateFormat ("dd/MM/yyyy");
			df.setLenient(false);
			Date d1;
			d1 = df.parse (Checkin);//07/09/1822
			Date d2 = df.parse (Checkout);
			dt = (d2.getTime() - d1.getTime()) + 3600000; // 1 hora para compensar horário de verão
			dt = (dt / 86400000L);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	public double convertToTwoDecimal(double valueTrip){
		DecimalFormat df = new DecimalFormat("###,##0.00");
		String formatTax = df.format(valueTrip); 
		Double valorDouble = Double.parseDouble(formatTax.replaceAll("\\.","").replace(",","."));
		return valorDouble;

	}
}
