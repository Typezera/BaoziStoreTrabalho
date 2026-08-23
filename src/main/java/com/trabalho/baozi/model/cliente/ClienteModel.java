package com.trabalho.baozi.model.cliente;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="cliente")
public class ClienteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nome;

    @CreationTimestamp
    LocalDateTime clienteDesde;

    public ClienteModel(){};

    public ClienteModel(Long id, String nome, LocalDateTime clienteDesde){
        this.id = id;
        this.nome = nome;
        this.clienteDesde = clienteDesde;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setClienteDesde(LocalDateTime clienteDesde) {
        this.clienteDesde = clienteDesde;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDateTime getClienteDesde() {
        return clienteDesde;
    }
}
