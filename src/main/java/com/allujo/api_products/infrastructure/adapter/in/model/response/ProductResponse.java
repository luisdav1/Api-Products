package com.allujo.api_products.infrastructure.adapter.in.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {


        private String name;


        private String description;


        private String price;


        private int quantity;

}
