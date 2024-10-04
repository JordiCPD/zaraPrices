package com.zara.prices;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import com.zara.prices.repository.InditexGroupRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.zara.prices.entity.InditexGroup;
import com.zara.prices.entity.Prices;
import com.zara.prices.repository.PricesRepository;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
class RepositoryTest {

    @Autowired
    private PricesRepository pricesRepository;

    @Autowired
    private InditexGroupRepository inditexGroupRepository;

    @Test
    @DisplayName("Test 1:Save Prices Test")
    @Order(1)
    @Rollback(value = false)
    void savePricesTest(){

        InditexGroup inditexGroup = InditexGroup.builder()
                .brand("Test")
                .brandId((int)5)
                .build();
        inditexGroup = inditexGroupRepository.saveAndFlush(inditexGroup);
        //Action
        Prices prices = Prices.builder()
                .currency("eur")
                .inditexGroup(inditexGroup)
                .price(Float.valueOf("35.5"))
                .startDate(new Timestamp(0))
                .endDate(new Timestamp(0))
                .priceList((int)1)
                .productId((int)1)
                .priority((int)1)
                .pricesId((int)200)
                .build();

                pricesRepository.save(prices);

        //Verify
        System.out.println(prices);
        Assertions.assertThat(prices.getPricesId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    void getPricesTest(){

        //Action
        Prices prices = pricesRepository.findById(Integer.valueOf("10")).get();
        //VerifyfindById
        System.out.println(prices);
        Assertions.assertThat(prices.getPricesId()).isEqualTo((int)10);
    }

    @Test
    @Order(3)
    void getListOfPricesTest(){
        //Action
        List<Prices> prices = pricesRepository.findAll();
        //Verify
        System.out.println(prices);
        Assertions.assertThat(prices.size()).isGreaterThan(0);

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    void updatePricesTest(){

        //Action
        Prices prices = pricesRepository.findById(Integer.valueOf("10")).get();
        prices.setCurrency("FRC");
        Prices pricesUpdated =  pricesRepository.save(prices);

        //Verify
        System.out.println(pricesUpdated);
        Assertions.assertThat(pricesUpdated.getCurrency()).isEqualTo("FRC");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    void deletePricesTest(){
        //Action
        pricesRepository.deleteById(Integer.valueOf("10"));
        Optional<Prices> pricesOptional = pricesRepository.findById(Integer.valueOf("10"));

        //Verify
        Assertions.assertThat(pricesOptional).isEmpty();
    }

}
