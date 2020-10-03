package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Pedido;
import com.example.demo.repository.PedidoRepository;

import resources.BaseController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController extends BaseController<Pedido, PedidoRepository> {

}
