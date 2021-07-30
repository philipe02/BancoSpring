package com.banco.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.banco.application.models.Cliente;
import com.banco.application.service.ClienteService;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteControllerV1 {

	@Autowired
	ClienteService clienteService;
	
	//criar rota para método POST
	@PostMapping
	public void incluirCliente(@RequestBody Cliente cliente) {
		System.out.println(cliente.toString());
	}
	
	@GetMapping("/pesquisarNome")
	public String pesquisarNome(@RequestParam("id") Integer matricula) {
		return clienteService.pesquisarNome(matricula);
	}

	@GetMapping("/pesquisarCliente")
	public Cliente pesquisarCliente(@RequestParam("cpf") Integer cpf) {
		return clienteService.pesquisarCliente(cpf);
	}

	@GetMapping("/genero/{genero}")
	public List<Cliente> pesquisarClientePorSexo(@PathVariable("genero") String sexo) {
		return clienteService.pesquisarClientePorSexo(sexo);
	}
}
