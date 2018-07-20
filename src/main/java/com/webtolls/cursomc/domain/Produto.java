package com.webtolls.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Produto  implements Serializable{// SERIALIZABLE SIGUINIFICA QUE OS OBJETOS DA CLASS PODERAM SER  
    										  // TRANSFORMADOS EM UMA SEQUENCIA DE BYTES, ISSO SERVE PARA QUE 
    										 // OS DADOS POSSAM SER ARMAZENADOS EM ARQUIVOS E TRAFEGAR NA REDE E ETC
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private double preco;
	
	@JsonBackReference// faz o seguinte, do outro lado da associação @JsonManagedReference ja foram buscados os objetos
					  // então eu não preciso buscar mais
	@ManyToMany // relacionamento muitos p muitos 
	@JoinTable(name = "PRODUTO_CATEGORIA", // Nome da tabela intermediária 
		joinColumns = @JoinColumn(name = "produto_id"), // chave extrangeira de produto
		inverseJoinColumns = @JoinColumn(name = "categoria_id") // chave extrangeira de categoria
	)
	private List<Categoria> categorias = new ArrayList<>(); // um produto tem uma ou mais categorias
	
	public Produto() {
		
	}

	public Produto(Integer id, String nome, double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	@Override// PARA QUE DOIS OBJETOS SEJA COMPARADOS PELO SEU CONTÚDO E NÃO PELO PONTEIRO DE MEMÓRIA
	  		// PARA COMPARAR DOIS OBJETOS POR VALOR. EH UM METODO QUE GERA UM CODIGO NUMERICO PARA CADA OBJETO
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override// PARA QUE DOIS OBJETOS SEJA COMPARADOS PELO SEU CONTÚDO E NÃO PELO PONTEIRO DE MEMÓRIA
	 		// PARA COMPARAR DOIS OBJETOS POR VALOR. EH O METODO QUE FAZ COMPARAÇÃO ENTRE DOIS OJETOS
	 		// CONSIDERANDO VARIAS POSSIBILIDADES
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
