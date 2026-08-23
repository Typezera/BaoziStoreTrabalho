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
    private ClienteModel clienteId;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private ProdutoModel produtoId;

    private Integer quantidade;

    public PedidoModel(){};
    public PedidoModel(Long id, ClienteModel clienteId, ProdutoModel produtoId, Integer quantidade){
        this.id = id;
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public ClienteModel getClienteId() {
        return clienteId;
    }

    public ProdutoModel getProdutoId() {
        return produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setClienteId(ClienteModel clienteId) {
        this.clienteId = clienteId;
    }

    public void setProdutoId(ProdutoModel produtoId) {
        this.produtoId = produtoId;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
