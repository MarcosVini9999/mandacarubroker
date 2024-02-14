package com.mandacarubroker.domain.stock;

import jakarta.persistence.*;
import lombok.*;

@Table(name ="stock")
@Entity(name="stock")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Stock {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String symbol;
    private String companyName;
    private double price;

    public Stock(RequestStockDTO requestStockDTO){
        this.symbol = requestStockDTO.symbol();
        this.companyName = requestStockDTO.companyName();
        this.price = changePrice(requestStockDTO.price(), true);
    }

    public double changePrice(double amount, boolean increase) {
        if (increase){
            return increasePrice(amount);
        }

        this.price=amount;

        return this.price;
    }

    public double increasePrice(double amount) {
        this.price = this.price + amount;
        return this.price;
    }

    public double decreasePrice(double amount) {
        this.price = this.price - amount;
        return this.price;
    }

}