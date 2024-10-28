package com.allujo.api_products;

import com.allujo.api_products.infrastructure.adapter.out.persistence.entity.ProductEntity;
import com.allujo.api_products.infrastructure.adapter.out.persistence.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class ApiProductsApplication implements CommandLineRunner {

	private final ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiProductsApplication.class, args);
	}

	@Override
	public  void run(String... args)  throws Exception {
		List<ProductEntity> entities = Arrays.asList(
				new ProductEntity(null,"Zapatos Addidas",1000.30,12, "Zapatos desportivos y de buena calidad", "USD"),
				new ProductEntity(null,"Zapatos Nike",1200.20,10, "Zapatos desportivos y de buena calidad", "USD"),
				new ProductEntity(null,"Zapatos Puma",4000.12,8, "Zapatos desportivos y de buena calidad", "USD"),
				new ProductEntity(null,"Zapatos Jordan Nike",1000,1, "Zapatos desportivos y de buena calidad", "EUR")
		);

		productRepository.saveAll(entities);
	}
}
