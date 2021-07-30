package com.banco.application.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "empregado")
public class Empregado {
	@Id
	@Column(name = "cpf")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer cpf;

	@Column
	public String nome;

	@ManyToOne
	@JoinColumn(name = "id_cargo")
	@JsonIgnoreProperties("empregados")
	public Cargo cargo;

	@ManyToOne
	@JoinColumn(name = "id_agencia")
	@JsonIgnoreProperties("empregados")
	public Agencia agencia;

}
