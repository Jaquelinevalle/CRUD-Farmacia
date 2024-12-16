package com.generation.farmacia.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "É obrigatório o atributo Nome")
	private String nome;
	
	@NotNull
	private Double valor;
	
	@NotNull
	private boolean disponivel;
	
   @ManyToOne
   @JsonIgnoreProperties("produto")
   private Categoria categoria;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public Double getValor() {
	return valor;
}

public void setValor(Double valor) {
	this.valor = valor;
}

public boolean isDisponivel() {
	return disponivel;
}

public void setDisponivel(boolean disponivel) {
	this.disponivel = disponivel;
}

public Categoria getCategoria() {
	return categoria;
}

public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}
   
  
}
