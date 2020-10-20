package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="pedido_produto", joinColumns=
    @JoinColumn(name="pedido_id"), inverseJoinColumns=
    @JoinColumn(name="produto_id"))
    private List<Produto> produto;
    @ManyToOne(fetch = FetchType.EAGER)
    private Cliente cliente;
    private String endereco;


}