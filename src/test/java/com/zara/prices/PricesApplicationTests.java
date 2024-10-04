package com.zara.prices;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zara.prices.common.constants.Constants;
import com.zara.prices.common.dto.FilterDto;
import com.zara.prices.common.dto.Response;
import com.zara.prices.dto.PricesDto;

@SpringBootTest
@AutoConfigureMockMvc
class PricesApplicationTests {

	@Autowired
	MockMvc mockMvc;

	ObjectMapper objectMapper = new ObjectMapper();

	@Test
	void testUno() throws Exception{
		
		FilterDto filterDto = new FilterDto("35455", "1","14-06-2020 10:00:00");
		
		MvcResult result = 
			mockMvc.perform(RestDocumentationRequestBuilders
				.post(Constants.API_BASE + Constants.API_VERSION001 + Constants.GET_PRICES_BY_FILTER)
				.content(asJsonString(filterDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
		String json = result.getResponse().getContentAsString();
		Response<List<PricesDto>> response = objectMapper.readValue(json, Response.class);
		Assertions.assertNotNull(response.getResult());
		List<PricesDto> listPrices = objectMapper.convertValue(response.getResult(), new TypeReference<List<PricesDto>>() {});
		System.out.println(listPrices);
		Assertions.assertNotEquals(listPrices.size(), 0);

	}

	@Test
	void testDos() throws Exception{
		
		FilterDto filterDto = new FilterDto("35455", "1","14-06-2020 16:00:00");
		
		MvcResult result = 
			mockMvc.perform(RestDocumentationRequestBuilders
				.post(Constants.API_BASE + Constants.API_VERSION001 + Constants.GET_PRICES_BY_FILTER)
				.content(asJsonString(filterDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
		String json = result.getResponse().getContentAsString();
		Response<List<PricesDto>> response = objectMapper.readValue(json, Response.class);
		Assertions.assertNotNull(response.getResult());
		List<PricesDto> listPrices = objectMapper.convertValue(response.getResult(), new TypeReference<List<PricesDto>>() {});
		System.out.println(listPrices);
		Assertions.assertNotEquals(listPrices.size(), 0);

	}

	@Test
	void testTres() throws Exception{
		
		FilterDto filterDto = new FilterDto("35455", "1","14-06-2020 21:00:00");
		
		MvcResult result = 
			mockMvc.perform(RestDocumentationRequestBuilders
				.post(Constants.API_BASE + Constants.API_VERSION001 + Constants.GET_PRICES_BY_FILTER)
				.content(asJsonString(filterDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
		String json = result.getResponse().getContentAsString();
		Response<List<PricesDto>> response = objectMapper.readValue(json, Response.class);
		Assertions.assertNotNull(response.getResult());
		List<PricesDto> listPrices = objectMapper.convertValue(response.getResult(), new TypeReference<List<PricesDto>>() {});
		System.out.println(listPrices);
		Assertions.assertNotEquals(listPrices.size(), 0);

	}

	@Test
	void testCuatro() throws Exception{
		
		FilterDto filterDto = new FilterDto("35455", "1","15-06-2020 10:00:00");
		
		MvcResult result = 
			mockMvc.perform(RestDocumentationRequestBuilders
				.post(Constants.API_BASE + Constants.API_VERSION001 + Constants.GET_PRICES_BY_FILTER)
				.content(asJsonString(filterDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
		String json = result.getResponse().getContentAsString();
		Response<List<PricesDto>> response = objectMapper.readValue(json, Response.class);
		Assertions.assertNotNull(response.getResult());
		List<PricesDto> listPrices = objectMapper.convertValue(response.getResult(), new TypeReference<List<PricesDto>>() {});
		System.out.println(listPrices);
		Assertions.assertNotEquals(listPrices.size(), 0);

	}

	@Test
	void testCinco() throws Exception{
		
		FilterDto filterDto = new FilterDto("35455", "1","16-06-2020 21:00:00");
		
		MvcResult result = 
			mockMvc.perform(RestDocumentationRequestBuilders
				.post(Constants.API_BASE + Constants.API_VERSION001 + Constants.GET_PRICES_BY_FILTER)
				.content(asJsonString(filterDto))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andReturn();
		String json = result.getResponse().getContentAsString();
		Response<List<PricesDto>> response = objectMapper.readValue(json, Response.class);
		Assertions.assertNotNull(response.getResult());
		List<PricesDto> listPrices = objectMapper.convertValue(response.getResult(), new TypeReference<List<PricesDto>>() {});
		System.out.println(listPrices);
		Assertions.assertNotEquals(0, listPrices.size());

	}

	public static String asJsonString(final Object obj){
		try{
			return new ObjectMapper().writeValueAsString(obj);
		}catch(Exception e){
			throw new RuntimeException();
		}
	}

	public static PricesDto getPrices(){
		return new PricesDto("35455", "1", 
		"1", "14-06-2020 00:00:00", 
		"31-12-2020 23:59:59", "35.5");
	}

}
