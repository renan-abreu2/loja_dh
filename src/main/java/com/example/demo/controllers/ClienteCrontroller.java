package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Cliente;
import com.example.demo.repository.ClienteRepository;

import resources.BaseController;

@RestController
@RequestMapping("/clientes")
public class ClienteCrontroller extends BaseController<Cliente, ClienteRepository> {

}
