package com.banco.application.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.banco.application.models.Cliente;

@Repository
public class ClienteRepository {
	// metodo responsavel por resgatar as informações do banco
	public String resgatarNome(Integer id) {
		HashMap<Integer, String> hashClientes = new HashMap<Integer, String>();

		hashClientes.put(1, "Duan");
		hashClientes.put(2, "Tayanne");
		hashClientes.put(3, "Henrique");

		String nome = hashClientes.get(id);
		return nome;
	}

	public Cliente resgatarCliente(Integer cpf) {
		HashMap<Integer, Cliente> hashClientes = new HashMap<Integer, Cliente>();

		hashClientes.put(1234, new Cliente("Duan", 1234, "M"));
		hashClientes.put(2345, new Cliente("Tayanne", 2345, "F"));
		hashClientes.put(3456, new Cliente("Henrique", 3456, "M"));

		Cliente cliente = hashClientes.get(cpf);
		return cliente;
	}

	public List<Cliente> resgatarClientePorSexo(String sexo) {
		HashMap<Integer, Cliente> hashClientes = new HashMap<Integer, Cliente>();
		List<Cliente> listaClientes = new ArrayList<>();

		hashClientes.put(1234, new Cliente("Duan", 1234, "M"));
		hashClientes.put(2345, new Cliente("Tayanne", 2345, "F"));
		hashClientes.put(3456, new Cliente("Henrique", 3456, "M"));

		for (Map.Entry<Integer, Cliente> entry : hashClientes.entrySet()) {
			Cliente value = entry.getValue();

			if (value.getSexo().equalsIgnoreCase(sexo)) {
				listaClientes.add(value);
			}
		}
		return listaClientes;
	}
}
