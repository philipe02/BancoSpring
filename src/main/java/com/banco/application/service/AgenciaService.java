package com.banco.application.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.banco.application.Repository.AgenciaRepository;
import com.banco.application.models.Agencia;
import com.banco.application.specification.AgenciaSpecification;

@Service
public class AgenciaService {

	@Autowired
	AgenciaRepository agenciaRepo;

	public Page<Agencia> buscarTodas(Integer numeroPagina, Integer itensPorPagina, String campoOrdenacao,
			String ordemOrdenacao, Integer id, String nome) {

		AgenciaSpecification specAgencia = new AgenciaSpecification(id, nome);

		PageRequest pageRequest = PageRequest.of(numeroPagina, itensPorPagina, Direction.fromString(ordemOrdenacao),
				campoOrdenacao);
		return agenciaRepo.findAll(specAgencia, pageRequest);
	}

	public ArrayList<Agencia> buscarPorFiltroSpecification(Integer id, String nome) {
		AgenciaSpecification specAgencia = new AgenciaSpecification(id, nome);

		return (ArrayList<Agencia>) agenciaRepo.findAll(specAgencia);
	}

}
