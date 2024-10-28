package com.allujo.api_products.infrastructure.adapter.in.mapper;

import com.allujo.api_products.domain.model.Product;
import com.allujo.api_products.infrastructure.adapter.in.model.request.ProductCreateRequest;
import com.allujo.api_products.infrastructure.adapter.in.model.response.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductCreateRequest request) {
        return new Product(
                request.getName(),
                request.getPrice(),
                request.getQuantity(),
                request.getDescription(),
                request.getCurrency()
        );
    }

    @Override
    public ProductResponse toProductResponse(Product product) {
        String priceFormater = product.getCurrency() + " " + product.getPrice();
        return new ProductResponse(
                product.getName(),
                product.getDescription(),
                priceFormater,
                product.getQuantity()
        );
    }

    @Override
    public List<ProductResponse> toProductResponseList(List<Product> products) {
        return products.stream()
                .map(this::toProductResponse)
                .collect(Collectors.toList());
    }
}
