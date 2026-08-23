package com.trabalho.baozi.service.produto;

import com.trabalho.baozi.model.produto.ProdutoModel;
import com.trabalho.baozi.repository.produto.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){this.produtoRepository=produtoRepository;}

    public ProdutoModel criarProdutor(ProdutoModel produtoModel){
        produtoRepository.findByNome(produtoModel.getNome())
                .ifPresent(prod -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST, "Produto não encontrado"
                    );
                });

        ProdutoModel prod = new ProdutoModel();
        prod.setNome(produtoModel.getNome());
        prod.setPreco(produtoModel.getPreco());
        prod.setEstoque(produtoModel.getEstoque());

        ProdutoModel saveProd = produtoRepository.save(prod);
        return saveProd;
    }

    public ProdutoModel buscarProduto(Long id){
        var prod = produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não existe"
                ));

        return new ProdutoModel(
                prod.getId(),
                prod.getNome(),
                prod.getPreco(),
                prod.getEstoque()

        );
    }

    public List<ProdutoModel>todosProdutos(){
        var produtos = produtoRepository.findAll();

        return produtos.stream().map( prod -> new ProdutoModel(
                prod.getId(),
                prod.getNome(),
                prod.getPreco(),
                prod.getEstoque()
        ))
                .toList();
    }

    public void removerProduto(Long id){
        produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Produto não encontrado"
                ));
        produtoRepository.deleteById(id);
    }

}
