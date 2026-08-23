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
}
