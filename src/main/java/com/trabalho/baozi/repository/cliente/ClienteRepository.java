package com.trabalho.baozi.repository.cliente;

import com.trabalho.baozi.model.cliente.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {

}
