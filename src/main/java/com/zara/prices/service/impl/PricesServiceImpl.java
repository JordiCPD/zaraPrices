package com.zara.prices.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zara.prices.dto.PricesDto;
import com.zara.prices.mapper.PricesMapper;
import com.zara.prices.repository.PricesRepository;
import com.zara.prices.service.PricesService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PricesServiceImpl implements PricesService{
        
    public final PricesRepository pricesRepository;

    public final PricesMapper pricesMapper;

    
    /** 
     * Search method
     * @param startDate
     * @param productId
     * @param brandId
     * @return List<PricesDto>
     */
    public List<PricesDto> findByStartDateOrProductIdOrBrandId(Date startDate, int productId, int brandId){
        return pricesMapper.listPricesToDto(pricesRepository.findByFilter(startDate,productId, brandId));
    }
}
