package com.zara.prices.service;

import java.util.Date;
import java.util.List;

import com.zara.prices.dto.PricesDto;

public interface PricesService {
    
    public List<PricesDto> findByStartDateOrProductIdOrBrandId(Date startDate, int productId, int brandId);
}
