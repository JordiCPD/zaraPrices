package com.zara.prices.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilterDto {
    
    private String identificadorProducto;
    private String identificadorCadena;
    private String fechaDeAplicacion;
}
