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
        @NotBlank(message = "Nome não pode ser vazio")
        private String nome;

        @NotBlank(message = "Telefone não pode ser vazio")
        @Size(min = 11, max = 11, message = "O tamanho do telefone deve ser 11 caracteres")
        private String telefone;

        @NotBlank(message = "Cpf não pode ser vazio")
        @Size(min = 11, max = 11, message = "O tamanho do cpf deve ser 11 caracteres")
        private String cpf;

        @NotBlank(message = "Email não pode ser vazio")
        @Email(message = "O email deve ser válido")
        private String email;

}