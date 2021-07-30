package com.banco.application.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.application.models.Cliente;
import com.banco.application.service.ClienteService;

@RestController
@RequestMapping("/api")
public class IndexController {

	@Autowired
	ClienteService clienteService;

	@GetMapping("/clientes")
	public ArrayList<Cliente> bemVindo() {
		return clienteService.findAll();
	}

	@GetMapping("/clientes/{cpf}")
	public Cliente clientePorCpf(@PathVariable("cpf") Integer cpf) {
		return clienteService.findById(cpf);
	}

	@GetMapping("/zap")
	public String bemVindoZappers() {
		return "Hello Zappers!";
	}
}
