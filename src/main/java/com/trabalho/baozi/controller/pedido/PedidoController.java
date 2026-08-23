package com.trabalho.baozi.controller.pedido;

import com.trabalho.baozi.model.pedido.PedidoModel;
import com.trabalho.baozi.service.pedido.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("api/pedido")
public class PedidoController {
    final private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){this.pedidoService=pedidoService;}

    @PostMapping("criar")
    public ResponseEntity<PedidoModel>criarPedido(
            @RequestBody PedidoModel pedidoModel
    ){
        var pedido = pedidoService.criarPedido(pedidoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<PedidoModel>buscarPedido(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(pedidoService.buscarPedido(id));
    }

    @GetMapping("buscar/todos")
    public ResponseEntity<List<PedidoModel>>buscarTodos(){
        return ResponseEntity.ok(pedidoService.todosPedidos());
    }

    @DeleteMapping("remover/{id}")
    public ResponseEntity<String>removerPedido(
            @PathVariable Long id
    ){
        pedidoService.removerPedido(id);
        return ResponseEntity.ok("Pedido removido com sucesso");
    }

}
