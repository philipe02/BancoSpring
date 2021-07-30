package com.banco.application.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.application.Repository.InstituicaoRepository;
import com.banco.application.models.InstituicaoFinanceira;

@Service
public class InstituicaoService {

	@Autowired
	InstituicaoRepository instituicaoRepository;

	public ArrayList<InstituicaoFinanceira> findAll() {
		return (ArrayList<InstituicaoFinanceira>) instituicaoRepository.findAll();
	}

	public ArrayList<InstituicaoFinanceira> findByName(String nome) {
		return (ArrayList<InstituicaoFinanceira>) instituicaoRepository.findByName(nome);
	}

	public void save(InstituicaoFinanceira instituicao) {
		instituicaoRepository.save(instituicao);
	}

	public InstituicaoFinanceira findById(Integer id) {
		return instituicaoRepository.findById(id).get();
	}

	public void update(Integer id, InstituicaoFinanceira instituicao) throws Exception {
		if (instituicaoRepository.existsById(id)) {
			instituicaoRepository.save(instituicao);
			return;
		}
		throw new Exception();
	}

}
