package com.webtolls.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.webtolls.cursomc.domain.Categoria;
import com.webtolls.cursomc.domain.Cidade;
import com.webtolls.cursomc.domain.Estado;
import com.webtolls.cursomc.domain.Produto;
import com.webtolls.cursomc.repositories.CategoriaRepository;
import com.webtolls.cursomc.repositories.CidadeRepository;
import com.webtolls.cursomc.repositories.EstadoRepository;
import com.webtolls.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner  {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
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
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2)); // salva uma lista de objetos de categoria no banco de dados
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3)); // salva uma lista de objetos de categoria no banco de dados 
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1  = new Cidade(null,"Uberlândia", est1);// quando é muitos para um, no proprio construtor fazemos a associação
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1)); // informa que a cidade c1 faz parte do estado est1
		est2.getCidades().addAll(Arrays.asList(c2,c3));// informa que a cidade c2 e c3 faz parte do estado est2
		
		estadoRepository.saveAll(Arrays.asList(est1,est2)); // salva uma lista de objetos do estado no banco de dados  
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3)); // salva uma lista de objetos de cidade no banco de dados 
		
		
	}
	
	//CommandLineRunner: uma interface que permite chamar o metodos run que permite executar uma ação desejada 
}
