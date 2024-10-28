package com.allujo.api_products.infrastructure.adapter.out.persistence.mapper;

import com.allujo.api_products.domain.model.Product;
import com.allujo.api_products.infrastructure.adapter.out.persistence.entity.ProductEntity;

import java.util.List;

public interface ProductPersistenceMapper {
    Product toProduct(ProductEntity productEntity);
    ProductEntity toProductEntity(Product product);
    List<Product> toProducts(List<ProductEntity> productEntities);
}
