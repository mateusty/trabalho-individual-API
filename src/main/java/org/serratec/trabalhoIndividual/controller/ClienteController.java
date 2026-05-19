package org.serratec.trabalhoIndividual.controller;

import jakarta.validation.Valid;
import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.model.ClienteInput;
import org.serratec.trabalhoIndividual.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Void> postCliente(@Valid @RequestBody ClienteInput clienteInput) {
        clienteService.postCliente(clienteInput);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getCliente(@RequestParam(required = false) String cpf,
                                                    @RequestParam(required = false) String nome) {
        List<Cliente> clientes = clienteService.getCliente(cpf, nome);

        if(clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable UUID id) {
        this.clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }
}