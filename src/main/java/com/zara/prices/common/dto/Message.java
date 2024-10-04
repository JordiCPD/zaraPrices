package com.zara.prices.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "code",
    "msg",
    "type"
})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @JsonProperty("code")
    protected String code;

    @JsonProperty("msg")
    protected String msg;

    @JsonProperty("type")
    protected String type;
    
}
