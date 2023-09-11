package com.example.rest.controller;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseCliente<T> {
    private Integer cve_error;
    private String cve_mensaje;
    private T cve_response;
}
