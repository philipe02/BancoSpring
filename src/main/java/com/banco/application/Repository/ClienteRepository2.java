package com.banco.application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banco.application.models.Cliente;

//Repositório que extende o JPA e vai ter a responsabilidade de executar
//operações em cliente
public interface ClienteRepository2 extends JpaRepository<Cliente, Integer> {

	@Query("SELECT cli FROM cliente cli WHERE telefone like %?1%")
	public List<Cliente> filterByTelephone(String tel);

}
