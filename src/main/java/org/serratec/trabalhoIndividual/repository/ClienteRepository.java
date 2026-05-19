package org.serratec.trabalhoIndividual.repository;

import org.serratec.trabalhoIndividual.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    List<Cliente> findByCpf(String cpf);
    List<Cliente> findByNome(String nome);
    List<Cliente> findByCpfAndNome(String cpf, String nome);
}
