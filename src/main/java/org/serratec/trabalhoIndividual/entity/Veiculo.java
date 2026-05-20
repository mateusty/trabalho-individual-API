package org.serratec.trabalhoIndividual.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.serratec.trabalhoIndividual.model.VeiculoInput;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @Column(nullable = false)
    private Integer ano;

    @Column(nullable = false)
    private Double valor;

    @Column(nullable = false)
    private String placa;

    @Column(nullable = false)
    private Double maximoDesconto;

    @Column(nullable = false)
    private Boolean vendido;

    @Column
    private Double valorVenda;

    public Veiculo(VeiculoInput veiculoInput, Cliente cliente) {
        this.cliente = cliente;
        this.marca = veiculoInput.getMarca();
        this.modelo = veiculoInput.getModelo();
        this.ano = veiculoInput.getAno();
        this.valor = veiculoInput.getValor();
        this.placa = veiculoInput.getPlaca();
        this.maximoDesconto = veiculoInput.getMaximoDesconto();
    }
}
