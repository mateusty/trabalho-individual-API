package org.serratec.trabalhoIndividual.service;

import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.entity.Veiculo;
import org.serratec.trabalhoIndividual.exception.NotFoundException;
import org.serratec.trabalhoIndividual.model.VeiculoInput;
import org.serratec.trabalhoIndividual.repository.ClienteRepository;
import org.serratec.trabalhoIndividual.repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private VeiculoRepository veiculoRepository;
    private ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
    }

    public void postVeiculo(VeiculoInput veiculoInput) {
        Cliente cliente = this.clienteRepository
                                .findById(veiculoInput.getClienteId())
                                .orElseThrow(() -> new NotFoundException(List.of("Não existe um cliente com o id " + veiculoInput.getClienteId())));
        this.veiculoRepository.save(new Veiculo(veiculoInput, cliente));
    }

//    public List<Veiculo> getVeiculo(String placa, String marca, String modelo) {
//
//    }
}
