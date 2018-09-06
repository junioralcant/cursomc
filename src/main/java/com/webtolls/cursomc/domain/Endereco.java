package com.webtolls.cursomc.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Endereco  implements Serializable {// SERIALIZABLE SIGUINIFICA QUE OS OBJETOS DA CLASS PODERAM SER  
    											// TRANSFORMADOS EM UMA SEQUENCIA DE BYTES, ISSO SERVE PARA QUE 
                                               // OS DADOS POSSAM SER ARMAZENADOS EM ARQUIVOS E TRAFEGAR NA REDE E ETC

    private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String logradora;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	
	@ManyToOne //// varios endereço tem apenas um cliente
	@JoinColumn(name="cliente_id")// chave estrangeira de cliente na tabela endereço
	private Cliente cliente; // varios endereço tem apenas um cliente
	
	@ManyToOne  //varios endereco tem apenas uma cidade
	@JoinColumn(name="cidade_id")// chave estrangeira de cidade na tabela endereço
	private Cidade cidade;// endereço tem uma cidade
	
	public Endereco() {
		
	}

	

	public Endereco(Integer id, String logradora, String numero, String complemento, String bairro, String cep,
			Cliente cliente, Cidade cidade) {
		super();
		this.id = id;
		this.logradora = logradora;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.cliente = cliente;
		this.setCidade(cidade);
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogradora() {
		return logradora;
	}

	public void setLogradora(String logradora) {
		this.logradora = logradora;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente clientes) {
		this.cliente = clientes;
	}



	public Cidade getCidade() {
		return cidade;
	}



	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}



	@Override // PARA QUE DOIS OBJETOS SEJA COMPARADOS PELO SEU CONTÚDO E NÃO PELO PONTEIRO DE MEMÓRIA
	  		 // PARA COMPARAR DOIS OBJETOS POR VALOR. EH UM METODO QUE GERA UM CODIGO NUMERICO PARA CADA OBJET
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
		Endereco other = (Endereco) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
	
}
