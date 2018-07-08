package com.webtolls.cursomc.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET) //PARA SER UMA FUNÇÃO REST TEM Q SER ASSOCIADA A ALGUM VERBO HTTP
	public String  listar() {
		return "Rest esta funcionando!";
	}
}
