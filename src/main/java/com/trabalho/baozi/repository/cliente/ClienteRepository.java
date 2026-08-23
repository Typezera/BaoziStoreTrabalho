package com.trabalho.baozi.repository.cliente;

import com.trabalho.baozi.model.cliente.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
    Optional<ClienteModel> findByNome(String nome);
}
