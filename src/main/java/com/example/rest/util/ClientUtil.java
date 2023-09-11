package com.example.rest.util;

import com.example.rest.controller.ResponseCliente;
import com.example.rest.model.Cliente;

import java.util.List;

public class ClientUtil {

    public static <T> ResponseCliente<T> createResponse(Integer code, String msg, T response) {
        return ResponseCliente.<T>builder()
                .cve_error(code)
                .cve_mensaje(msg)
                .cve_response(response)
                .build();
    }

    public static <T> ResponseCliente<T> createResponseOk( String msg, T response) {
        return createResponse(0, msg, response);
    }
    public static <T> ResponseCliente<T> createResponseError( String msg) {
        return createResponse(1, msg, null );
    }
}
