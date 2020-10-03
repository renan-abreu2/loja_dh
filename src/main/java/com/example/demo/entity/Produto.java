package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import resources.BaseEntity;

@Entity
@Getter
@Setter
public class Produto extends BaseEntity {

	private String nome;
	private Float preco;

	@ManyToOne
	@JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
	private Categoria categoria;

	@ManyToMany(mappedBy = "produtos")
	@JsonIgnoreProperties("produtos")
	private List<Pedido> pedidos;
}
