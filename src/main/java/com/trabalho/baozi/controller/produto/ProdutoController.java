package com.trabalho.baozi.controller.produto;

import com.trabalho.baozi.model.cliente.ClienteModel;
import com.trabalho.baozi.model.produto.ProdutoModel;
import com.trabalho.baozi.service.produto.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping("api/produto")
public class ProdutoController {
    final private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService){this.produtoService=produtoService;}

    @PostMapping("criar")
    public ResponseEntity<ProdutoModel>criarProduto(
            @RequestBody ProdutoModel produtoModel
    ){
        var prod = produtoService.criarProdutor(produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(prod);
    }

    @GetMapping("buscar/{id}")
    public ResponseEntity<ProdutoModel>buscarProduto(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(produtoService.buscarProduto(id));
    }

    @GetMapping("buscar/todos")
    public ResponseEntity<List<ProdutoModel>>buscarTodos(){
        return ResponseEntity.ok(produtoService.todosProdutos());
    }

    @DeleteMapping("remover/{id}")
    public ResponseEntity<String>removerPrduto(
            @PathVariable Long id
    ){
        produtoService.removerProduto(id);
        return ResponseEntity.ok("Produto removido com sucesso.");
    }
}
