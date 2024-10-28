package com.allujo.api_products.infrastructure.adapter.out.persistence;

import com.allujo.api_products.application.port.out.ProductRepositoryPort;
import com.allujo.api_products.domain.model.Product;
import com.allujo.api_products.infrastructure.adapter.out.persistence.mapper.ProductPersistenceMapper;
import com.allujo.api_products.infrastructure.adapter.out.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductPersistenceAdapter implements ProductRepositoryPort {
    private final ProductRepository productRepository;
    private final ProductPersistenceMapper productMapper;

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toProduct);
    }

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(
                productRepository.save(productMapper.toProductEntity(product))
        );
    }

    @Override
    public List<Product> findAll() {
        return productMapper.toProducts(productRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
