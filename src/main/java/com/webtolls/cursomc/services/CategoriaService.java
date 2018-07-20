package com.webtolls.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webtolls.cursomc.domain.Categoria;
import com.webtolls.cursomc.repositories.CategoriaRepository;
import com.webtolls.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired //INSTACIA ALTOMATICAMENTE O OBJETO
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( //ObjectNotFoundException vem do pacote com.webtolls.cursomc.services.exceptions.
					"Objeto não encontrado! Id: " + id + ", Tipo" +Categoria.class.getName()));
	}
}
