package com.trabalho.baozi.repository.produto;

import com.trabalho.baozi.model.produto.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
}
