package com.mandacarubroker.service;


import com.mandacarubroker.domain.stock.RequestStockDTO;
import com.mandacarubroker.domain.stock.Stock;
import com.mandacarubroker.domain.stock.StockRepository;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StockServiceTests {

    @Autowired
    private StockService stockService;

    @MockBean
    private StockRepository stockRepository;

    private RequestStockDTO requestStockDTO;
    final String symbol = "Xq5";
    final String companyName = "Apple Inc.";
    final Double price = 150.0;

    @BeforeEach
    public void setUp() {
        requestStockDTO = new RequestStockDTO(symbol, companyName, price);
    }

    @Test
    public void shouldReturnAllStocks() {
        List<Stock> expectedStocks = Collections.singletonList(new Stock(requestStockDTO));
        Mockito.when(stockRepository.findAll()).thenReturn(expectedStocks);

        List<Stock> actualStocks = stockService.getAllStocks();

        assertEquals(expectedStocks, actualStocks);
    }

    @Test
    public void shouldReturnEmptyListWhenNoStocksAvailable() {
        Mockito.when(stockRepository.findAll()).thenReturn(Collections.emptyList());

        List<Stock> actualStocks = stockService.getAllStocks();

        assertTrue(actualStocks.isEmpty());
        Mockito.verify(stockRepository).findAll();
    }

    @Test
    public void shouldGetStockByIdSuccessfully() {
        String id = "123";
        Stock expectedStock = new Stock(requestStockDTO);
        Mockito.when(stockRepository.findById(id)).thenReturn(Optional.of(expectedStock));

        Optional<Stock> actualStock = stockService.getStockById(id);

        assertTrue(actualStock.isPresent());
        assertEquals(expectedStock, actualStock.get());
        Mockito.verify(stockRepository).findById(id);
    }

    @Test
    public void shouldReturnEmptyOptionalForNonExistentId() {
        String nonExistentId = "nonexistent";
        Mockito.when(stockRepository.findById(nonExistentId)).thenReturn(Optional.empty());

        Optional<Stock> actualStock = stockService.getStockById(nonExistentId);

        assertFalse(actualStock.isPresent());
        Mockito.verify(stockRepository).findById(nonExistentId);
    }

    @Test
    public void shouldCreateStockWithValidData() {
        Stock expectedStock = new Stock(requestStockDTO);

        Mockito.when(stockRepository.save(expectedStock)).thenReturn(expectedStock);

        Stock createdStock = stockService.createStock(requestStockDTO);

        Mockito.verify(stockRepository).save(expectedStock);
        assertEquals(expectedStock, createdStock);
    }

    @Test
    public void shouldThrowConstraintViolationExceptionForInvalidSymbol() {
        String invalidSymbol = "invalid$#";
        RequestStockDTO invalidData = new RequestStockDTO(invalidSymbol, "Invalid Company", 0.0);

        assertThrows(ConstraintViolationException.class, () -> stockService.createStock(invalidData));
    }

    @Test
    public void shouldUpdateStockSuccessfully() {
    }


    @Test
    public void shouldDeleteStockSuccessfully() {
    }



    @Test
    public void shouldValidateAndCreateStockWithValidData() {
    }
}
