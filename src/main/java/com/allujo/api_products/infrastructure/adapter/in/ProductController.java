package com.allujo.api_products.infrastructure.adapter.in;

import com.allujo.api_products.application.port.in.ProductServicePort;
import com.allujo.api_products.infrastructure.adapter.in.mapper.ProductMapper;
import com.allujo.api_products.infrastructure.adapter.in.model.request.ProductCreateRequest;
import com.allujo.api_products.infrastructure.adapter.in.model.response.ProductResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductServicePort productService;
    private  final ProductMapper productMapper;

    @GetMapping("/v1/api")
    public List<ProductResponse> getAllProducts() { return productMapper.toProductResponseList(productService.getAllProducts());}

    @GetMapping("/v1/api/{id}")
    public ProductResponse findByIdProduct(@PathVariable Long id) { return productMapper.toProductResponse(productService.getProductById(id));}

    @PostMapping("/v1/api")
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody ProductCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(productMapper.toProductResponse(
                        productService.createProduct(productMapper.toProduct(request))));
    }

    @PutMapping("/v1/api/{id}")
    public ProductResponse update(@PathVariable Long id, @Valid @RequestBody ProductCreateRequest request) {
        return productMapper.toProductResponse(
                productService.updateProduct(id, productMapper.toProduct(request)));
    }

    @DeleteMapping("/v1/api/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProductById(id);
    }
}
