package com.webtolls.cursomc.domain;

import java.io.Serializable;

public class Categoria implements Serializable {// SERIALIZABLE SIGUINIFICA QUE OS OBJETOS DA CLASS PODERAM SER  
						                       // TRANSFORMADOS EM UMA SEQUENCIA DE BYTES, ISSO SERVE PARA QUE 
					                          // OS DADOS POSSAM SER ARMAZENADOS EM ARQUIVOS E TRAFEGAR NA REDE E ETC

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public Categoria() {
		
	}

	public Categoria(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	@Override // PARA QUE DOIS OBJETOS SEJA COMPARADOS PELO SEU CONTÚDO E NÃO PELO PONTEIRO DE MEMÓRIA
			  // PARA COMPARAR DOIS OBJETOS POR VALOR. EH UM METODO QUE GERA UM CODIGO NUMERICO PARA CADA OBJETO
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override // PARA QUE DOIS OBJETOS SEJA COMPARADOS PELO SEU CONTÚDO E NÃO PELO PONTEIRO DE MEMÓRIA
			 // PARA COMPARAR DOIS OBJETOS POR VALOR. EH O METODO QUE FAZ COMPARAÇÃO ENTRE DOIS OJETOS
			 // CONSIDERANDO VARIAS POSSIBILIDADES
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
