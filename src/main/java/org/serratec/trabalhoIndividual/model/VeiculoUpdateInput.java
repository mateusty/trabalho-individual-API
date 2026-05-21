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

    private String marca;

    private String modelo;

    @Min(value = 1900, message = "Ano deve ser maior ou igual à 1900")
    private Integer ano;

    @Min(value = 1, message = "Valor deve ser ou igual à 1")
    private Double valor;

    @Min(value = 0, message = "maximoDesconto deve ser maior ou igual à 0")
    private Double maximoDesconto;

    private Boolean vendido;

    private Double valorVenda;

    @AssertTrue(message = "Valor venda não pode ser nulo caso vendido for verdadeiro")
    @JsonIgnore
    public boolean valorVendaValidation() {
        if (getVendido() && valorVenda == null) {
            return false;
        }
        return true;
    }
}