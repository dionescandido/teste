package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.domain.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;


    @PostMapping("/salvar")
    public ResponseEntity<Pedido> salvar( @RequestBody Pedido pedido){

        Pedido result = pedidoService.salvar(pedido);
        return ResponseEntity.ok(result);

    }




}
