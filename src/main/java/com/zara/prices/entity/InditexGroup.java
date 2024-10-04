package com.zara.prices.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Builder
@NoArgsConstructor
@Table(name = "INDITEX_GROUP")
@AllArgsConstructor
public class InditexGroup implements Serializable {

    private static final long serialVersionUID = -2550049032597028386L;

    @Column(name = "INDITEX_GROUP_ID")
    @Id
    @GeneratedValue(generator="INDITEX_GROUP_SEQ")
    @SequenceGenerator(name="INDITEX_GROUP_SEQ" ,sequenceName="INDITEX_GROUP_SEQ", allocationSize=1)
    private int inditexGroupId;

    @Column(name = "BRAND_ID" , unique = true)
    private int brandId;

    @Column(name = "BRAND")
    private String brand;
    
}
