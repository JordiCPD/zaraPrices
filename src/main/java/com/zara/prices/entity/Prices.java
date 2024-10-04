package com.zara.prices.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
@Table(name = "PRICES")
@NoArgsConstructor
@AllArgsConstructor
public class Prices implements Serializable{

    private static final long serialVersionUID = -5009076941612731461L;

    @Column(name = "PRICES_ID")
    @Id
    @GeneratedValue(generator="PRICES_SEQ")
    @SequenceGenerator(name="PRICES_SEQ",sequenceName="PRICES_SEQ", allocationSize=1)
    private int pricesId;

    @Column(name = "START_DATE")
    private Timestamp startDate;

    @Column(name = "END_DATE")
    private Timestamp endDate;

    @Column(name = "PRICE_LIST")
    private int priceList;

    @Column(name = "PRODUCT_ID")
    private int productId;

    @Column(name = "PRIO")
    private int priority;

    @Column(name = "PRICE")
    private float price;

    @Column(name = "CURRENCY")
    private String currency;

    @ManyToOne()
    @JoinColumn(name = "BRAND_ID")
    private InditexGroup inditexGroup;
}
