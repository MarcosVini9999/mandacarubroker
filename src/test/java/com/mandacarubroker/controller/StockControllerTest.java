package com.mandacarubroker.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mandacarubroker.domain.stock.RequestStockDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

@SpringBootTest
@AutoConfigureMockMvc
public class StockControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    RequestStockDTO requestStockDTO = new RequestStockDTO("Xq5", "Apple Inc.", 150.0);

    String stockId;

    @DisplayName("Should save a stock")
    @BeforeEach
    public void StockTestSave() throws Exception{
        MvcResult result  = mockMvc.perform(post("/stocks").contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestStockDTO)))
                .andExpect(status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();

        JsonNode responseNode = objectMapper.readTree(responseBody);

        stockId = responseNode.get("id").asText();
    }

    @DisplayName("Should get all stocks")
    @Test
    public void StockTestGetAll() throws Exception{
        mockMvc.perform(get("/stocks")).andExpect(status().isOk());
    }

    @DisplayName("Should put a stock")
    @Test
    public void StockTestPut() throws Exception{
        RequestStockDTO requestStockToPutDTO = new RequestStockDTO("Sq5", "Samsung", 250.0);

        mockMvc.perform(put("/stocks/"+stockId).contentType("application/json")
                .content(objectMapper.writeValueAsString(requestStockToPutDTO)))
                .andExpect(status().isOk())
                .andReturn();
    }

    @DisplayName("Should show a stock")
    @Test
    public void StockTestShow() throws Exception{

        mockMvc.perform(get("/stocks/"+stockId)).andExpect(status().isOk());
    }

    @DisplayName("Should delete a stock")
    @AfterEach
    public void tearDown()throws Exception{
        mockMvc.perform(delete("/stocks/"+stockId).contentType("application/json")
                        .content(objectMapper.writeValueAsString(requestStockDTO)))
                .andExpect(status().isOk());
    }


}
