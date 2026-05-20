package org.serratec.trabalhoIndividual.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoUpdateInput {

    @NotBlank(message = "Marca não pode ser vazio")
    private String marca;

    @NotBlank(message = "Modelo não pode ser vazio")
    private String modelo;

    @NotNull(message = "Ano não pode ser nulo")
    @Min(value = 1900, message = "Ano deve ser maior ou igual à 1900")
    private Integer ano;

    @NotNull(message = "Valor não pode ser nulo")
    @Min(value = 1, message = "Valor deve ser ou igual à 1")
    private Double valor;

    @NotNull(message = "maximoDesconto não pode ser nulo")
    @Min(value = 0, message = "maximoDesconto deve ser maior ou igual à 0")
    private Double maximoDesconto;

    @NotNull(message = "O campo 'vendido' não deve ser nulo")
    private boolean vendido;

    private Double valorVenda;

    @AssertTrue(message = "Valor venda não pode ser nulo caso vendido for verdadeiro")
    @JsonIgnore
    public boolean valorVendaValidation() {
        if (isVendido() && valorVenda == null) {
            return false;
        }
        return true;
    }
}