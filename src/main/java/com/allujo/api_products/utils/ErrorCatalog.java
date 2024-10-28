package com.allujo.api_products.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    PRODUCT_NOT_FOUND("ERR_PRODUCT_001", "Producto no encontrado"),
    INVALID_PRODUCT("ERR_PRODUCT_002", "Invalido argumento"),
    GENERIC_ERROR("ERR_GEN_001", "Un inesperado error ocurrio");

    private final String code;
    private final String message;

    ErrorCatalog(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
