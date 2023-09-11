package com.example.rest.service;

import com.example.rest.controller.ResponseCliente;
import com.example.rest.model.Cliente;

import java.util.List;

public interface ClienteService {

    ResponseCliente<List<Cliente>> obtenerTodosClientes();

    ResponseCliente<Cliente> obtenerClientePorClienteId(Integer clienteId);

    ResponseCliente<Cliente> crearCliente(Cliente cliente);
    ResponseCliente<Cliente> actualizarCliente(Integer clienteId, Cliente cliente);

    ResponseCliente<String> eliminarCliente(Integer clienteId);

}
