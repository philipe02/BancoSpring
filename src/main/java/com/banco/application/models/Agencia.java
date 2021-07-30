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
@Entity(name = "agencia")
public class Agencia {

	@Id
	@Column(name = "id_agencia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nome;

	@ManyToOne
	@JoinColumn(name = "id_instituicao")
	@JsonIgnoreProperties({ "agencias", "contas" })
	private InstituicaoFinanceira instituicao;

}
