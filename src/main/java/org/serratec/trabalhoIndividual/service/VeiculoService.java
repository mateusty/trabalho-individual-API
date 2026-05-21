package org.serratec.trabalhoIndividual.service;

import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.entity.Veiculo;
import org.serratec.trabalhoIndividual.exception.NotFoundException;
import org.serratec.trabalhoIndividual.model.VeiculoInput;
import org.serratec.trabalhoIndividual.model.VeiculoUpdateInput;
import org.serratec.trabalhoIndividual.repository.ClienteRepository;
import org.serratec.trabalhoIndividual.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void postVeiculo(VeiculoInput veiculoInput) {
        Cliente cliente = this.clienteRepository
                                .findById(veiculoInput.getClienteId())
                                .orElseThrow(() -> new NotFoundException("Não existe um cliente com o id " + veiculoInput.getClienteId()));
        this.veiculoRepository.save(new Veiculo(veiculoInput, cliente));
    }

    public List<Veiculo> getVeiculo(String placa, String marca, String modelo) {
        boolean temPlaca = placa != null && !placa.isBlank();
        boolean temMarca = marca != null && !marca.isBlank();
        boolean temModelo = modelo != null && !modelo.isBlank();
        List<Veiculo> veiculos = new ArrayList<>();

        if(temPlaca) {
            List<Veiculo> veiculosPlaca = this.veiculoRepository.findByPlaca(placa);
            veiculos.addAll(veiculosPlaca);
        }
        if(temMarca) {
            List<Veiculo> veiculosMarca = this.veiculoRepository.findByMarca(marca);
            veiculos.addAll(veiculosMarca);
        }
        if(temModelo) {
            List<Veiculo> veiculosModelo = this.veiculoRepository.findByModelo(modelo);
            veiculos.addAll(veiculosModelo);
        }
        if(!(temPlaca && temMarca && temModelo)) {
            List<Veiculo> todosVeiculos = this.veiculoRepository.findAll();
            veiculos.addAll(todosVeiculos);
        }

        if(veiculos.isEmpty()) {
            List<String> msg = new ArrayList<>();
            if (temPlaca) {
                msg.add("Não existem veículos com a placa: " + placa);
            }
            if (temMarca) {
                msg.add("Não existem veículos com a marca: " + marca);
            }
            if (temModelo) {
                msg.add("Não existem veículos com o modelo: " + modelo);
            }
            throw new NotFoundException(
                    String.join(" : ", msg)
            );
        }
        return veiculos;
    }

    public void putVeiculo(UUID id, VeiculoUpdateInput veiculo) {
        Veiculo veiculoDB = this.veiculoRepository.findById(id).orElseThrow(() -> new NotFoundException("Não existe um veiculo com o id: " + id));

        //Posso usar Reflection para mappear de forma mais eficiente, ou um mapper
        if(veiculo.getMarca() != null) {
            veiculoDB.setMarca(veiculo.getMarca());
        }
        if(veiculo.getModelo() != null) {
            veiculoDB.setModelo(veiculo.getModelo());
        }
        if(veiculo.getAno() != null) {
            veiculoDB.setAno(veiculo.getAno());
        }
        if(veiculo.getValor() != null) {
            veiculoDB.setValor(veiculo.getValor());
        }
        if(veiculo.getMaximoDesconto() != null) {
            veiculoDB.setMaximoDesconto(veiculo.getMaximoDesconto());
        }
        if(veiculo.getVendido() != null) {
            veiculoDB.setVendido(veiculo.getVendido());
        }
        if(veiculo.getValorVenda() != null) {
            veiculoDB.setValorVenda(veiculo.getValorVenda());
        }

        this.veiculoRepository.save(veiculoDB);
    }

    public void deleteVeiculo(UUID id) {
        if(!this.veiculoRepository.existsById(id)) {
            throw new NotFoundException("Não existe um veiculo cadastrado com o id: " + id);
        }
        else {
            this.veiculoRepository.deleteById(id);
        }
    }
}
