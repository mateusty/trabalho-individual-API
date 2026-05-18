package org.serratec.trabalhoIndividual.repository;

import org.serratec.trabalhoIndividual.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
