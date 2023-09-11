package com.example.rest.repository;

import com.example.rest.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Optional<Cliente> findByClienteId(Integer clienteId);
    Optional<Cliente> findByCorreoElectronicoOrNombreUsuario(String correoElectronico, String nombreUsuario);
    void deleteByClienteId(Integer clienteId);

}
