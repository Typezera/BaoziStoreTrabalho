package com.trabalho.baozi.model.cliente;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    BigDecimal preco;

    Boolean estoque;
}
