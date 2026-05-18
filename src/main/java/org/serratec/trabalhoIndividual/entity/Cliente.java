package org.serratec.trabalhoIndividual.entity;

import jakarta.persistence.*;
import org.serratec.trabalhoIndividual.model.ClienteInput;

import java.util.UUID;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String email;

    public Cliente(ClienteInput clienteInput) {
        this.nome = clienteInput.nome();
        this.telefone = clienteInput.telefone();
        this.cpf = clienteInput.cpf();
        this.email = clienteInput.email();
    }
}
