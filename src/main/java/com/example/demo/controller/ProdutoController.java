package com.example.demo.controller;


import com.example.demo.domain.Produto;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



}
