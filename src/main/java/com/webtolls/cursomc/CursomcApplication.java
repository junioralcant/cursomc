package com.webtolls.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.webtolls.cursomc.domain.Categoria;
import com.webtolls.cursomc.domain.Produto;
import com.webtolls.cursomc.repositories.CategoriaRepository;
import com.webtolls.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner  {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRespository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null,"Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3)); // informa quais produtos fazem parte da categoria 1
		cat2.getProdutos().addAll(Arrays.asList(p2)); //informa quais produtos fazem parte da categoria 2
		
		p1.getCategorias().addAll(Arrays.asList(cat1));//informa que protudo 1 faz parte da categoria 1
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));//informa que protudo 2 faz parte da categoria 1 e da categoria 2
		p3.getCategorias().addAll(Arrays.asList(cat1));//informa que protudo 3 faz parte da categoria 1
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2)); // salva uma lista de objetos de categoria
		produtoRespository.saveAll(Arrays.asList(p1,p2,p3)); // salva uma lista de objetos de categoria
	}
	
	//CommandLineRunner: uma interface que permite chamar o metodos run que permite executar uma ação desejada 
}
