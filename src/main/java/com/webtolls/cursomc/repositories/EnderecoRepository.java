package com.webtolls.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webtolls.cursomc.domain.Endereco;;

@Repository // DA TODO ACESSO DE MANIPULACAO DE DADOS PARA ESSA INTERFACE, COMO DELETAR INSERIR E ETC
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
