package org.serratec.trabalhoIndividual.controller;

import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.model.ClienteInput;
import org.serratec.trabalhoIndividual.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Void> postCliente(@RequestBody ClienteInput clienteInput) {
        clienteService.postCliente(clienteInput);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Cliente> getCliente(@RequestParam(required = false) String cpf,
                                              @RequestParam(required = false) String nome) {
    }
}