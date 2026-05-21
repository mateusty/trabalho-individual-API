package org.serratec.trabalhoIndividual.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoIndividual.entity.Veiculo;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponse {

    private UUID id;
    private UUID idCliente;
    private String marca;
    private String modelo;
    private Integer ano;
    private Double valor;
    private String placa;
    private Double maximoDesconto;
    private Boolean vendido;
    private Double valorVenda;

    public VeiculoResponse(Veiculo veiculo) {
        this.id = veiculo.getId();
        this.idCliente = veiculo.getCliente().getId();
        this.marca = veiculo.getMarca();
        this.modelo = veiculo.getModelo();
        this.ano = veiculo.getAno();
        this.valor = veiculo.getValor();
        this.placa = veiculo.getPlaca();
        this.maximoDesconto = veiculo.getMaximoDesconto();
        this.vendido = veiculo.getVendido();
        this.valorVenda = veiculo.getValorVenda();
    }
}
