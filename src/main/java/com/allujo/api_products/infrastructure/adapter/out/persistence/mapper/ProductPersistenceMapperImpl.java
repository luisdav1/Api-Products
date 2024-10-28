package com.allujo.api_products.infrastructure.adapter.out.persistence.mapper;

import com.allujo.api_products.domain.model.Product;
import com.allujo.api_products.infrastructure.adapter.out.persistence.entity.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductPersistenceMapperImpl implements ProductPersistenceMapper {
    @Override
    public Product toProduct(ProductEntity productEntity) {
        return new Product(
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getQuantity(),
                productEntity.getDescription(),
                productEntity.getCurrency(),
                productEntity.getId()
        );
    }

    @Override
    public ProductEntity toProductEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantity(product.getQuantity());
        productEntity.setDescription(product.getDescription());
        productEntity.setCurrency(product.getCurrency());
        productEntity.setId(product.getId());
        return productEntity;
    }

    @Override
    public List<Product> toProducts(List<ProductEntity> productEntities) {
        return productEntities.stream()
                .map(this::toProduct)
                .collect(Collectors.toList());
    }
}
