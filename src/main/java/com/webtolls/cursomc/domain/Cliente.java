package com.webtolls.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.webtolls.cursomc.domain.enums.TipoCliente;

@Entity
public class Cliente  implements Serializable {// SERIALIZABLE SIGUINIFICA QUE OS OBJETOS DA CLASS PODERAM SER  
    										  // TRANSFORMADOS EM UMA SEQUENCIA DE BYTES, ISSO SERVE PARA QUE 
											 // OS DADOS POSSAM SER ARMAZENADOS EM ARQUIVOS E TRAFEGAR NA REDE E ETC

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String cpfOuCnpj;
	private Integer tipo; // internamente o tipo de cliente sera armazenado com inteiro
						 // mas para o mundo externa class vai expor um dado do TipoCliente
	
	@OneToMany (mappedBy="cliente")// um para muitos. esta se relacionando com mapeamento do atributo
									// estado do outro lado
	private List<Endereco> enderecos = new ArrayList<>(); // um cliente tem varios endereço	
	
	@ElementCollection // informa que é uma entidade fraca
	@CollectionTable(name="Telefone") //da um nome a tabela 
	private Set<String> telefones = new HashSet<>(); // Set é um conjunto e conjunto não aceita repetição, esta sendo criado um conjunto de string
													// e não averar repetção 
	public Cliente() {
		
	}
	public Cliente(Integer id, String nome, String email,String cpfOuCnpj, TipoCliente tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.tipo = tipo.getCod(); // getCod() pq ele eh do TipoCliente e estamos atribino ele a um interiro, então para não dar erro
			 					  // especifico para ele que queremos só o codigo, dessa forma n da erro
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}
	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}
	
	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);// chamo o metodo toEnum da class TipoCliente
	}
	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();// getCod() pq ele eh do TipoCliente e estamos atribino ele a um interiro, então para não dar erro
		  						 // especifico para ele que queremos só o codigo, dessa forma n da erro
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	public Set<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
