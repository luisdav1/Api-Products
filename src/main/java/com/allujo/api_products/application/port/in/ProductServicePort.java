package com.allujo.api_products.application.port.in;

import com.allujo.api_products.domain.model.Product;

import java.util.List;

public interface ProductServicePort {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProductById(Long id);
    Product updateProduct(Long id, Product product);
}
