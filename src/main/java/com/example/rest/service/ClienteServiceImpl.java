package com.example.rest.service;

import com.example.rest.controller.ResponseCliente;
import com.example.rest.model.Cliente;
import com.example.rest.repository.ClienteRepository;
import com.example.rest.util.ClientUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    public static final String MSG_INFO_ALL = "Info Obtenida";
    public static final String MSG_CLIENT_FOUND = "Cliente encontrado";
    public static final String MSG_CLIENT_NOT_FOUND = "Cliente no encontrado";
    public static final String MSG_EMAIL_USERNAME_EXIST = "Correo electrónico o nombre de usuario ya existe";
    public static final String MSG_CLIENT_CREATED = "Cliente creado";
    public static final String MSG_CLIENT_UPDATED = "Cliente actualizado";
    public static final String MSG_CLIENT_DELETED = "Cliente eliminado";


    private final ClienteRepository repository;

    @Override
    public ResponseCliente<List<Cliente>> obtenerTodosClientes() {
        return ClientUtil.createResponseOk(MSG_INFO_ALL, repository.findAll());
    }

    @Override
    public ResponseCliente<Cliente> obtenerClientePorClienteId(Integer clienteId) {
        Optional<Cliente> info = repository.findByClienteId(clienteId);
        if (info.isPresent()) {
            return ClientUtil.createResponseOk(MSG_CLIENT_FOUND, info.get());
        }
        return ClientUtil.createResponseError(MSG_CLIENT_NOT_FOUND);
    }

    @Override
    public ResponseCliente<Cliente> crearCliente(Cliente cliente) {
        Optional<Cliente> info = repository.findByCorreoElectronicoOrNombreUsuario(cliente.getCorreoElectronico(),
                cliente.getNombreUsuario());
        if (info.isPresent()) {
            return ClientUtil.createResponseError(MSG_EMAIL_USERNAME_EXIST);
        }
        return ClientUtil.createResponseOk(MSG_CLIENT_CREATED, repository.save(cliente));
    }

    @Override
    public ResponseCliente<Cliente> actualizarCliente(Integer clienteId, Cliente cliente) {
        Optional<Cliente> info = repository.findByClienteId(clienteId);
        if (info.isPresent()) {
            Cliente temporal = info.get();
            temporal.setPeso(cliente.getPeso());
            temporal.setEstatura(cliente.getEstatura());
            return ClientUtil.createResponseOk(MSG_CLIENT_UPDATED, repository.save(temporal));
        }
        return ClientUtil.createResponseError(MSG_CLIENT_NOT_FOUND);
    }

    @Override
    public ResponseCliente<String> eliminarCliente(Integer clienteId) {
        Optional<Cliente> info = repository.findByClienteId(clienteId);
        if (info.isPresent()) {
            repository.deleteByClienteId(clienteId);
            return ClientUtil.createResponseOk(MSG_CLIENT_DELETED, "CLIENT ID: " + clienteId);
        }
        return ClientUtil.createResponseError(MSG_CLIENT_NOT_FOUND);
    }
}
