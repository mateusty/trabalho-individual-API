package org.serratec.trabalhoIndividual.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteInput {
        @NotNull
        @NotBlank
        private String nome;

        @NotNull
        @NotBlank
        private String telefone;

        @NotNull
        @NotBlank
        @Size(min = 11, max = 11)
        private String cpf;

        @NotNull
        @NotBlank
        @Email
        private String email;

}