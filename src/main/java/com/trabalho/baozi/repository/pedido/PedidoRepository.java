package com.trabalho.baozi.repository.pedido;

import com.trabalho.baozi.model.pedido.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
