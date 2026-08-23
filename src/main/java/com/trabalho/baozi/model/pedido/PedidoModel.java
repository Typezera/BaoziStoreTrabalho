package com.trabalho.baozi.model.pedido;

import com.trabalho.baozi.model.cliente.ClienteModel;
import com.trabalho.baozi.model.produto.ProdutoModel;
import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel cliente;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produtoId;

    private Integer quantidade;
}
