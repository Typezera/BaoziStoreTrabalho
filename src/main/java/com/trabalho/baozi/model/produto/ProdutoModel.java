package com.trabalho.baozi.model.produto;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produto_domain")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    BigDecimal preco;

    Boolean estoque;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Boolean getEstoque() {
        return estoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setEstoque(Boolean estoque) {
        this.estoque = estoque;
    }
}
