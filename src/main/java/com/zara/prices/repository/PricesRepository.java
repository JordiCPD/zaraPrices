package com.zara.prices.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zara.prices.entity.Prices;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer>{

   @Query("select p from Prices p where  :startDate between p.startDate and p.endDate and p.productId = :productId and p.inditexGroup.brandId=:brandId")
   List<Prices> findByFilter(@Param("startDate") Date startDate, @Param("productId") int productId, @Param("brandId") int brandId);
    
}
