package com.banco.application.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.application.Repository.CargoRepository;
import com.banco.application.models.Cargo;

@Service
public class CargoService {

	@Autowired
	CargoRepository cargoRepo;

	public ArrayList<Cargo> findAll() {
		return (ArrayList<Cargo>) cargoRepo.findAll();
	}

}
