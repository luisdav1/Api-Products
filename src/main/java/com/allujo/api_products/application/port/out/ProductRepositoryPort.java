package com.allujo.api_products.application.port.out;

import com.allujo.api_products.domain.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    Optional<Product> findById(Long id);
    Product save(Product product);
    List<Product> findAll();
    void deleteById(Long id);
}
