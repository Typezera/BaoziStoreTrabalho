package com.trabalho.baozi.controller.cliente;

import com.trabalho.baozi.model.cliente.ClienteModel;
import com.trabalho.baozi.service.cliente.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("buscar/{id}")
    public ResponseEntity<ClienteModel>encontrarCliente(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @GetMapping("buscar/todos")
    public ResponseEntity<List<ClienteModel>>todosClientes(){
        return ResponseEntity.ok(clienteService.todosClientes());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deletarClinete(
            @PathVariable Long id
    ){
        clienteService.deletarCliente(id);
        return ResponseEntity.ok("Cliente removido com sucesso");
    }
}
