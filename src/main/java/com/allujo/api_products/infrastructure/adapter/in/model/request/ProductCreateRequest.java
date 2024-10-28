package com.allujo.api_products.infrastructure.adapter.in.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductCreateRequest {

    @NotBlank(message = "El campo name no puede estar vacio o ser null")
    private String name;

    @NotBlank(message = "El campo description no puede ser vacio o null")
    private String description;

    @NotNull(message = "El campo price no puede ser vacio o null")
    private Double price;

    @NotNull(message = "El campo quantity no puede ser vacio o null")
    private Integer quantity;

    @NotBlank(message = "El campo currency no puede ser vacio o null")
    private String currency;
}

