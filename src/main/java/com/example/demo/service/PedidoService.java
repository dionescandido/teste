package com.example.demo.service;

import com.example.demo.domain.Pedido;
import com.example.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;


    public Pedido salvar(Pedido pedido){

        return pedidoRepository.save(pedido);


    }

}
