package com.trabalho.baozi.service.cliente;

import com.trabalho.baozi.model.cliente.ClienteModel;
import com.trabalho.baozi.repository.cliente.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService (ClienteRepository clienteRepository){this.clienteRepository = clienteRepository;}


    public ClienteModel cadastrarCliente(ClienteModel clienteModel){
        clienteRepository.findByNome(clienteModel.getNome())
                .ifPresent(cliente -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Cliente já foi cadastrado."
                    );
                });

        ClienteModel cliente = new ClienteModel();
        cliente.setNome(clienteModel.getNome());

        ClienteModel cli = clienteRepository.save(cliente);

        return cli;
    }
}
