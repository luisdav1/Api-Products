package com.allujo.api_products.infrastructure.adapter.in.mapper;

import com.allujo.api_products.domain.model.Product;
import com.allujo.api_products.infrastructure.adapter.in.model.request.ProductCreateRequest;
import com.allujo.api_products.infrastructure.adapter.in.model.response.ProductResponse;

import java.util.List;

public interface ProductMapper {

    Product toProduct(ProductCreateRequest request);

    ProductResponse toProductResponse(Product product);

    List<ProductResponse> toProductResponseList(List<Product> products);
}
