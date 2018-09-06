package com.webtolls.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webtolls.cursomc.domain.Cliente;

@Repository // DA TODO ACESSO DE MANIPULACAO DE DADOS PARA ESSA INTERFACE, COMO DELETAR INSERIR E ETC
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
