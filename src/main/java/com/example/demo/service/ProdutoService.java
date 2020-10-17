package com.example.demo.service;

import com.example.demo.domain.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto salvar(Produto produto){

        return produtoRepository.save(produto);

    }


    public List<Produto> listar(){

        List<Produto> produtos = produtoRepository.findAll();

        return produtos;

    }

}
