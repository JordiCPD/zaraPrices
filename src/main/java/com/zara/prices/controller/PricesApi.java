package com.zara.prices.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.zara.prices.common.dto.FilterDto;
import com.zara.prices.common.dto.Response;
import com.zara.prices.dto.PricesDto;

public interface PricesApi {


    public ResponseEntity<Response<List<PricesDto>>> getPricesByFilter (@RequestBody (required = true) FilterDto filterDto);
    
}
