package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Produto;
import com.example.demo.repository.ProdutoRepository;

import resources.BaseController;

@RestController
@RequestMapping("/produto")
public class ProdutoController extends BaseController<Produto, ProdutoRepository> {

}
