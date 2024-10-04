package com.zara.prices.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zara.prices.common.constants.Constants;
import com.zara.prices.common.dto.FilterDto;
import com.zara.prices.common.dto.Message;
import com.zara.prices.common.dto.Response;
import com.zara.prices.dto.PricesDto;
import com.zara.prices.service.PricesService;
import com.zara.prices.utils.Utils;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(Constants.API_BASE + Constants.API_VERSION001)
@RequiredArgsConstructor
public class PricesApiController implements PricesApi{

    private final PricesService pricesService;

    
    /** 
     * @param filterDto
     * @return ResponseEntity<Response<List<PricesDto>>>
     */
    @Override
    @PostMapping(
        path = Constants.GET_PRICES_BY_FILTER,
        produces =  MediaType.APPLICATION_JSON_VALUE,
        consumes =  MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Response<List<PricesDto>>> getPricesByFilter (@RequestBody (required = true) FilterDto filterDto){

        Response<List<PricesDto>> response = null;

        try{
            List <PricesDto> listPricesDto = pricesService.findByStartDateOrProductIdOrBrandId(Utils.getDatefromString(filterDto.getFechaDeAplicacion()),
                Integer.parseInt(filterDto.getIdentificadorProducto()),Integer.parseInt(filterDto.getIdentificadorCadena()));
            List <Message> message = List.of(
                Message.builder().code("200").msg("Ok").type("INFO").build()
                );
            response = Response.<List<PricesDto>>builder().status("ok").message(message).result(listPricesDto).build();
        }catch (Exception e){
            List <Message> message = List.of(
                Message.builder().code("").msg(e.getMessage()).type("ERROR").build()
                );
            response = Response.<List<PricesDto>>builder().status("ok").message(message).result(null).build();            
        }
        return ResponseEntity.ok(response);
    }
    
}
