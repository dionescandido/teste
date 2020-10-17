package com.example.demo.controller;


import com.example.demo.domain.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @PostMapping("/salvar")
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){

        Produto result = produtoService.salvar(produto);
        return ResponseEntity.ok(result);

    }


    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> listar(){

        return ResponseEntity.ok(produtoService.listar());
    }


}
