package com.trabalho.baozi.controller.cliente;

import com.trabalho.baozi.model.cliente.ClienteModel;
import com.trabalho.baozi.service.cliente.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    final private ClienteService clienteService;

    public ClienteController(ClienteService clienteService){this.clienteService = clienteService;}

    @PostMapping("criar")
    public ResponseEntity<ClienteModel>criar(
            @RequestBody
            ClienteModel clienteModel
    ){
        var cliente = clienteService.cadastrarCliente(clienteModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }
}
