package com.trabalho.baozi.service.pedido;

import com.trabalho.baozi.model.pedido.PedidoModel;
import com.trabalho.baozi.repository.cliente.ClienteRepository;
import com.trabalho.baozi.repository.pedido.PedidoRepository;
import com.trabalho.baozi.repository.produto.ProdutoRepository;
import com.trabalho.baozi.service.cliente.ClienteService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository){
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public PedidoModel criarPedido(PedidoModel pedidoModel){
        var cliente = clienteRepository
                .findById(pedidoModel.getClienteId().getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Cliente não encontrado"
                ));

        var produto = produtoRepository
                .findById(pedidoModel.getProdutoId().getId())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado"
                ));



        PedidoModel pedido = new PedidoModel();
        pedido.setClienteId(cliente);
        pedido.setProdutoId(produto);
        pedido.setQuantidade(pedidoModel.getQuantidade());

        return pedidoRepository.save(pedido);

    }

    public PedidoModel buscarPedido(Long id){
        var pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Pedido não encontrado "
                ));

        return new PedidoModel(
                pedido.getId(),
                pedido.getClienteId(),
                pedido.getProdutoId(),
                pedido.getQuantidade()
        );
    }

    public List<PedidoModel>todosPedidos(){
        var pedidos = pedidoRepository.findAll();

        return pedidos.stream().map(pedido -> new PedidoModel(
                pedido.getId(),
                pedido.getClienteId(),
                pedido.getProdutoId(),
                pedido.getQuantidade()
        ))
                .toList();
    }

    public void removerPedido(Long id){
        pedidoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Pedido não encontrado"
                ));
        pedidoRepository.deleteById(id);
    }
}
