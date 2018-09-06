package com.webtolls.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA (1, "Pessoa Física"),
	PESSOAJURIDICA(2,"Pessoa Jurítica");
	
	private int cod;
	private String decricao;
	
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.decricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDecricao() {
		return decricao;
	}
	
	//essa operação recebe um codigo e retorna um objeto do tipo cliente
	// já instaciado comforme o codigo passado acima PESSOAFISICA (1, "Pessoa Física"),PESSOAJURIDICA(2,"Pessoa Jurítica");
	
	public static TipoCliente toEnum(Integer cod) { // metodo static vc pode rodar ele mesmo sem esta instaciado
		if(cod == null) {
			return null;
		}
		
		for (TipoCliente x : TipoCliente.values()) { // faz uma busca, todo obj x nos valores possíveis no tipo cliente
													// percorre todos o valores do tipo cliente	
			
			if(cod.equals(x.getCod())) {// se o codigo que veio como argumento for igual ao codigo existente 
				return x;				// entao ele vai retorna o x. 	
			}
		}
		
		throw new IllegalArgumentException("Id iválido: " + cod);
	}
	
	// por padrão o jpa salvara no banco dois tipos de dados, savara o nome em forma de string
	// ou em foma numerica começanco em zero. 
	// mas importante especificar o numero para cada tipo de cliente para evitar futoros erros na manuenção do codigo
}
