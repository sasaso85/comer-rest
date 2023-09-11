package com.example.rest.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "cliente")
@Data
@RequiredArgsConstructor
public class Cliente {
    @Id
    private String id;
    private Integer clienteId;
    private String nombreUsuario;
    private String contrasenia;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private Integer edad;
    private Double estatura;
    private Double peso;
    private Double IMC;
    private Double GEB;
    private Double ETA;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

}
