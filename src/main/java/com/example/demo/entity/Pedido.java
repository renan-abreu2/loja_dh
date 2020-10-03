package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import resources.BaseEntity;

@Entity
@Getter
@Setter
public class Pedido extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	@JsonIgnoreProperties("pedidos")
	private Cliente cliente;
	
	private LocalDateTime dataPedido;

	@ManyToMany
	@JoinTable(
		name = "item_pedido", 
		joinColumns = @JoinColumn(name = "pedido_id"), 
		inverseJoinColumns = @JoinColumn(name = "produto_id")
	)
	@JsonIgnoreProperties("pedidos")
	private List<Produto> produtos;
}
