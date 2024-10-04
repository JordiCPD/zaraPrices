package com.zara.prices.common.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "message",
    "result"
})
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    @JsonProperty("status")
    protected String status;

    @JsonProperty("messages")
    protected List<Message> message;

    @JsonProperty("result")
    protected T result;
    
}
