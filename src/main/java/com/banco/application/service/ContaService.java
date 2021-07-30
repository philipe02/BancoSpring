package com.banco.application.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.application.Repository.ContaRepository;
import com.banco.application.models.Agencia;
import com.banco.application.models.Conta;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;

	public ArrayList<Conta> findAll() {
		Agencia agencia = new Agencia();
		agencia.setNome("AAAAAAAAAAAAAAAAAAAAAAzap");
		System.out.println(agencia.getNome());
		return (ArrayList<Conta>) contaRepository.findAll();

	}
}
