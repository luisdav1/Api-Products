package com.allujo.api_products.application.service;

import com.allujo.api_products.application.port.in.ProductServicePort;
import com.allujo.api_products.application.port.out.ProductRepositoryPort;
import com.allujo.api_products.domain.exception.ProductNotFoundException;
import com.allujo.api_products.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductServicePort {

    private final ProductRepositoryPort repository;

    @Override
    public Product createProduct(Product product) {
        return this.repository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return this.repository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public void deleteProductById(Long id) {

        if (this.repository.findById(id).isEmpty()) {
            throw new ProductNotFoundException();
        }

        this.repository.deleteById(id);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return repository.findById(id)
                .map(savedProduct -> {
                    savedProduct.setName(product.getName());
                    savedProduct.setDescription(product.getDescription());
                    savedProduct.setPrice(product.getPrice());
                    savedProduct.setQuantity(product.getQuantity());
                    savedProduct.setCurrency(product.getCurrency());
                    return this.repository.save(savedProduct);
                }).orElseThrow(ProductNotFoundException::new);
    }
}
