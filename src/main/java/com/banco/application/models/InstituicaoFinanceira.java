package com.banco.application.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "instituicao_financeira")
public class InstituicaoFinanceira {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer identifier;

	@Column(name = "nome")
	private String nome;

	@OneToMany(mappedBy = "instituicao")
	private List<Conta> contas;

	@OneToMany(mappedBy = "instituicao")
	private List<Agencia> agencias;

	public InstituicaoFinanceira() {

	}

	public InstituicaoFinanceira(String nome) {
		this.setNome(nome);
	}

	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Conta> getContas() {
		return contas;
	}

	public void setContas(List<Conta> contas) {
		this.contas = contas;
	}

}
