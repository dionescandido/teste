package com.example.demo.service;


import com.example.demo.domain.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Cliente salvar(Cliente cliente){

        return clienteRepository.save(cliente);

    }

}
