package com.br.stay.hotels.interfaces;

import java.util.List;

import com.br.stay.hotels.model.Hotel;

import feign.Param;
import feign.RequestLine;
/**
 * Interface Utilizada para uso do Feign, com isso ganhamos em performace, somente é chamado em tempo de execução 
 * @author Bdecco
 *
 */
public interface IStayFeign {

	@RequestLine("GET /{id}")
	public List<Hotel> calculateStayByHotelId(@Param("id") String id) throws Exception;
	@RequestLine("GET /{id}")
	public List<Hotel> calculateStayByAvailHotelId(@Param("id") String id) throws Exception;
}
