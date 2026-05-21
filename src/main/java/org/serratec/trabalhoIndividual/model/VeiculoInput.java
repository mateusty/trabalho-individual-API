package org.serratec.trabalhoIndividual.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoInput {

    @NotNull(message = "O Veiculo precisa de um cliente")
    private UUID clienteId;

    @NotBlank(message = "Marca não pode ser vazio")
    private String marca;

    @NotBlank(message = "Modelo não pode ser vazio")
    private String modelo;

    @NotNull(message = "Ano não pode ser nulo")
    @Min(value = 1900, message = "Ano deve ser maior ou igual à 1900")
    private Integer ano;

    @NotNull(message = "Valor não pode ser nulo")
    @Min(value = 1, message = "Valor deve ser maior ou igual à 1")
    private Double valor;

    @NotBlank(message = "Placa não pode ser vazia")
    private String placa;

    @NotNull(message = "Máximo Desconto não pode ser nulo")
    @Min(value = 0, message = "maximoDesconto deve ser maior ou igual à 0")
    private Double maximoDesconto;
}
