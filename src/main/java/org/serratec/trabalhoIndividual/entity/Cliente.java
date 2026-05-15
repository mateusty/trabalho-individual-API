package org.serratec.trabalhoIndividual.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String nome;

    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String telefone;

    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @NotNull
    @NotBlank
    @Column(nullable = false, unique = true)
    private String email;
}
