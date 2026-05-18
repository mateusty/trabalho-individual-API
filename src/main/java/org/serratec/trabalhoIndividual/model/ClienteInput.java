package org.serratec.trabalhoIndividual.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ClienteInput(
        @NotNull
        @NotBlank
        String nome,

        @NotNull
        @NotBlank
        String telefone,

        @NotNull
        @NotBlank
        @Size(min = 11, max = 11)
        String cpf,

        @NotNull
        @NotBlank
        @Email
        String email
) {

}
