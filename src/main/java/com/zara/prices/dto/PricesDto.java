package com.zara.prices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PricesDto {
    
    private String identificadorProducto;

    private String identificadorCadena;

    private String tarifaAplicar;

    private String fechaAplicacionInicio;

    private String fechaAplicacionFin;

    private String precioFinal;
}
