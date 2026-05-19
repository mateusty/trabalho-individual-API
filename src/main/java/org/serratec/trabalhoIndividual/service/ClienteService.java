package org.serratec.trabalhoIndividual.service;

import org.serratec.trabalhoIndividual.entity.Cliente;
import org.serratec.trabalhoIndividual.exception.NotFoundException;
import org.serratec.trabalhoIndividual.model.ClienteInput;
import org.serratec.trabalhoIndividual.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void postCliente(ClienteInput clienteInput) {
        this.clienteRepository.save(new Cliente(clienteInput));
    }

    public List<Cliente> getCliente(String cpf, String nome) {
        boolean temCpf = cpf != null && !cpf.isBlank();
        boolean temNome = nome != null && !nome.isBlank();

        if(temCpf && temNome) {
            List<Cliente> clientes = this.clienteRepository.findByCpfAndNome(cpf, nome);
            if (clientes.isEmpty()) {
                throw new NotFoundException(List.of("Não existe um cliente com o cpf " + cpf + " e nome " + nome));
            }
            return clientes;
        }
        else if (temCpf) {
            List<Cliente> clientes = this.clienteRepository.findByCpf(cpf);
            if(clientes.isEmpty()) {
                throw new NotFoundException(List.of("Não existe um cliente com o cpf: " + cpf));
            }
            return clientes;
        }
        else if (temNome) {
            List<Cliente> clientes = this.clienteRepository.findByNome(nome);
            if(clientes.isEmpty()) {
                throw new NotFoundException(List.of("Não existe um cliente com o nome: " + nome));
            }
            return clientes;
        }
        return this.clienteRepository.findAll();
    }

    public void deleteCliente(UUID id) {
        if(this.clienteRepository.existsById(id)) {
            this.clienteRepository.deleteById(id);
        }
        else {
            throw new NotFoundException(List.of("Cliente com o id " + id + " Não encontrado"));
        }
    }
}
