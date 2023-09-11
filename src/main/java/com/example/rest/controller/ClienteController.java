package com.example.rest.controller;

import com.example.rest.model.Cliente;
import com.example.rest.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/NutriNET/Cliente")
@AllArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping()
    public ResponseEntity<ResponseCliente<List<Cliente>>> obtenerTodosClientes() {
        return ResponseEntity.ok(clienteService.obtenerTodosClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCliente<Cliente>> obtenerClientePorClienteId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(clienteService.obtenerClientePorClienteId(id));
    }

    @PostMapping()
    public ResponseEntity<ResponseCliente<Cliente>> crearCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteService.crearCliente(cliente), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCliente<Cliente>> actualizarCliente(
            @PathVariable("id") Integer id,
            @RequestBody Cliente cliente) {
        return ResponseEntity.ok(clienteService.actualizarCliente(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseCliente<String>> eliminarCliente(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(clienteService.eliminarCliente(id));
    }
}
