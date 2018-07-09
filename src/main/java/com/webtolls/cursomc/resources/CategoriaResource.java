package com.webtolls.cursomc.resources;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webtolls.cursomc.domain.Categoria;
import com.webtolls.cursomc.services.CategoriaService;

@RestController 
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired //INSTANCIA AUTOMATICAMENTE O OBJ
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET) //PARA SER UMA FUNÇÃO REST TEM Q SER ASSOCIADA A ALGUM VERBO HTTP
	public ResponseEntity<?>  find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//ResponseEntity<?>: Armazena e encapsula varias informações de uma resposta HTTP para o tipo REST. a "?" quer dizer que pode ser qualquer tipo.
	//value="/{id}": Informa que na URL vai ser acrescentato o ID da categoria EX: /categorias/1  
	//@PathVariable Integer id: Informa que o id irformado no parametro vaiser redirecionado para a URL
	//ResponseEntity.ok(): Da um ok se tudo ocorrer bem 
	//.body(obj): Informa que o corpo do metodo vai ser a variável obj
}
