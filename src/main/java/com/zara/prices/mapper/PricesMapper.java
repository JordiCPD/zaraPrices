package com.zara.prices.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.zara.prices.dto.PricesDto;
import com.zara.prices.entity.Prices;
import com.zara.prices.utils.Utils;

@Component
public class PricesMapper {
    
    
    /** 
     * Return pricesDto from prices
     * @param prices
     * @return PricesDto
     */
    public PricesDto pricesToDto (Prices prices){

        PricesDto pricesDto = null;

        pricesDto = PricesDto.builder()
            .identificadorProducto(String.valueOf(prices.getProductId()))
            .identificadorCadena(String.valueOf(prices.getInditexGroup().getBrandId()))
            .tarifaAplicar(String.valueOf(prices.getPriceList()))
            .fechaAplicacionFin(Utils.getStringfromDate(prices.getEndDate()))
            .fechaAplicacionInicio(Utils.getStringfromDate(prices.getStartDate()))
            .precioFinal(String.valueOf(prices.getPrice())).build();

        return pricesDto;
    }

    
    /** 
     * Return List pricesDto from List prices
     * @param listPrices
     * @return List<PricesDto>
     */
    public List<PricesDto> listPricesToDto(List <Prices> listPrices){        
        List<PricesDto> listPricesDto = null;
        if(listPrices != null && !listPrices.isEmpty()){
            listPricesDto = listPrices.stream().map(this::pricesToDto).toList();
        }
        return listPricesDto;
    }
}