package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import resources.BaseEntity;

@Entity // clientes
@Table(name = "cliente") // neste caso é opcional
@Getter
@Setter
public class Cliente extends BaseEntity {

	@NotNull(message = "O nome do cliente é obrigatório!")
	private String nome;

	private String cpf;

	@NotBlank(message = "Telefone não pode ser vazio!")
	private String telefone;
	
	@OneToOne(mappedBy = "cliente")
	@JsonIgnoreProperties("cliente")
	private Endereco endereco;
	
	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<Pedido> pedidos;

}
