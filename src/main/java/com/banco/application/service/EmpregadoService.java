package com.banco.application.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.application.Repository.EmpregadoRepository;
import com.banco.application.models.Empregado;

@Service
public class EmpregadoService {

	@Autowired
	EmpregadoRepository empregadoRepo;

	public ArrayList<Empregado> findAll() {
		return (ArrayList<Empregado>) empregadoRepo.findAll();
	}
}
