package com.banco.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.application.Repository.ClienteRepository;
import com.banco.application.Repository.ClienteRepository2;
import com.banco.application.models.Cliente;

//anotacao que transforma essa classe em um 
//Bean que será gerenciado pelo framework
@Service
//classe responsavel pelas regras de negocio de cliente
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ClienteRepository2 clienteJPARepository;

	public ArrayList<Cliente> findAll() {
		ArrayList<Cliente> listaRetorno = new ArrayList<>();
		listaRetorno = (ArrayList<Cliente>) clienteJPARepository.findAll();
		return listaRetorno;
	}

	public Cliente findById(Integer cpf) {
		Optional<Cliente> oCliente;
		oCliente = clienteJPARepository.findById(cpf);
		return oCliente.get();
	}

	public String pesquisarNome(Integer id) {
		return clienteRepository.resgatarNome(id);
	}

	public Cliente pesquisarCliente(Integer cpf) {
		return clienteRepository.resgatarCliente(cpf);
	}

	public List<Cliente> pesquisarTelefone(String tel) {
		return clienteJPARepository.filterByTelephone(tel);
	}

	public List<Cliente> pesquisarClientePorSexo(String sexo) {
		return clienteRepository.resgatarClientePorSexo(sexo);
	}
}
