package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Endereco;
import com.example.demo.repository.Endereco_Repository;

import resources.BaseController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController extends BaseController<Endereco, Endereco_Repository> {

}
