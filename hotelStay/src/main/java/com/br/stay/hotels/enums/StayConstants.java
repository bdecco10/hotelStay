package com.br.stay.hotels.enums;

public enum StayConstants {
	
	HOTELS_AVAIL("https://cvcbackendhotel.herokuapp.com/hotels/avail/{id}"),
	HOTELS_ID("https://cvcbackendhotel.herokuapp.com/hotels/{id}"),
	HOTELS_AVAIL_FEIGN("https://cvcbackendhotel.herokuapp.com/hotels/avail"),
	HOTELS_ID_FEIGN("https://cvcbackendhotel.herokuapp.com/hotels");
 
    private String descricao;
 
    StayConstants(String descricao) {
        this.descricao = descricao;
    }
 
    public String getDescricao() {
        return descricao;
    }
}
