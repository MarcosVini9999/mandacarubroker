package com.mandacarubroker.domain.stock;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StockTest {
    private RequestStockDTO requestStockDTO;

    final String symbol = "AAPL";
    final String companyName = "Apple Inc.";
    final Double price = 150.0;

    @BeforeEach
    public void setUp() {
        requestStockDTO = new RequestStockDTO(symbol, companyName, price);
    }

    @DisplayName("Should create a stock")
    @Test
    public void testCreateStock(){
        Stock stock = new Stock(requestStockDTO);
        Assertions.assertEquals(stock.getSymbol(), symbol, "Should price be set");
        Assertions.assertEquals(stock.getCompanyName(), companyName, "Should price be set");
        Assertions.assertEquals(stock.getPrice(), price, "Should price be set");
    }

    @DisplayName("Should change the value with false increase")
    @Test
    public void testChangePriceWithFalseIncrease(){
        Stock stock = new Stock(requestStockDTO);
        stock.changePrice(160, false);
        Assertions.assertEquals(160, stock.getPrice());
    }

    @DisplayName("Should change the value with true increase")
    @Test
    public void testChangePriceWithTrueIncrease(){
        Stock stock = new Stock(requestStockDTO);
        stock.changePrice(160, true);
        Assertions.assertEquals(160 + price, stock.getPrice());
    }

    @DisplayName("Should increase the value")
    @Test
    public void testIncreasePrice(){
        Stock stock = new Stock(requestStockDTO);
        stock.increasePrice(50);
        Assertions.assertEquals(price + 50, stock.getPrice());
    }

    @DisplayName("Should decrease the value")
    @Test
    public void testDecreasePrice(){
        Stock stock = new Stock(requestStockDTO);
        stock.decreasePrice(50);
        Assertions.assertEquals(price - 50, stock.getPrice());
    }
}
