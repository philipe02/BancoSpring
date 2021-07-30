package com.banco.application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.banco.application.models.InstituicaoFinanceira;

@Repository
public interface InstituicaoRepository extends JpaRepository<InstituicaoFinanceira, Integer> {

	@Query("SELECT inst FROM instituicao_financeira inst WHERE nome like %?1%")
	public List<InstituicaoFinanceira> findByName(String nome);
}
