package com.banco.application.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
//import com.fasterxml.jackson.annotation.JsonIgnore;

//anotação para mapear meu model com minha tabela
@Entity(name = "cliente")
public class Cliente {
	// anotação para indicar que é a primary key
	@Id
	private Integer cpf;
	@Column(name = "nome")
	private String name;
	// @JsonIgnore
	@Column
	private String sexo;
	@Column
	private String telefone;
	@OneToMany(mappedBy = "cliente")
	List<Conta> contas;

	public Cliente() {
	}

	public Cliente(String nome, Integer cpf, String sexo) {
		this.setNome(nome);
		this.setCpf(cpf);
		this.setSexo(sexo);
	}

	public String getNome() {
		return name;
	}

	public void setNome(String name) {
		this.name = name;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

	@Override
	public String toString() {
		return "nome: " + this.getNome() + " cpf: " + this.getCpf() + " sexo: " + this.getSexo();
	}
}
