package com.allujo.api_products.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Product {
    @Setter
    private String name;

    private  double price;
    private Integer quantity;

    @Setter
    private String description;


    private String currency;

    @Setter
    private Long id;

    public Product(String name, double price, Integer quantity, String description, String currency) {
        this.name = name;
        setPrice(price);
        setQuantity(quantity);
        this.description = description;
        this.currency = currency;
        this.id = null;
    }

    public Product(String name, double price, Integer quantity, String description, String currency, Long id) {
        this.name = name;
        setPrice(price);
        setQuantity(quantity);
        this.description = description;
        this.currency = currency;
        this.id = id;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        if (quantity != null && quantity < 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        this.quantity = quantity;
    }

    public void setCurrency(String currency) {
        if (currency == null) {
            throw new IllegalArgumentException("La moneda no puede ser nulo");
        }

        if (currency.length() != 3) {
            throw new IllegalArgumentException("La moneda debe tener unicamente 3 caracteres");
        }

        this.currency = currency;
    }
}
