package com.example.rest.controller.advice;

import com.example.rest.controller.ResponseCliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseCliente<String>> handleRuntimeException(RuntimeException exception) {
        log.error("Message: {}", exception.getMessage());
        ResponseCliente<String> response =
                ResponseCliente.<String>builder()
                        .cve_error(-500)
                        .cve_mensaje("ERROR INTERNO EN PROCESO")
                        .cve_response("ERROR")
                        .build();
        return ResponseEntity.internalServerError().body(response);
    }
}
