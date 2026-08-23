package com.trabalho.baozi.repository.produto;

import com.trabalho.baozi.model.cliente.ClienteModel;
import com.trabalho.baozi.model.pedido.PedidoModel;
import com.trabalho.baozi.model.produto.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    Optional<ProdutoModel> findByNome(String nome);
}
