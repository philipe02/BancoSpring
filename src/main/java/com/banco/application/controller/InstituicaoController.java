package com.banco.application.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banco.application.models.InstituicaoFinanceira;
import com.banco.application.service.InstituicaoService;

@RestController
@RequestMapping("/v1/instituicao")
public class InstituicaoController {

	// ponto de injecao do service
	@Autowired
	InstituicaoService instituicaoService;

	@GetMapping
	public ResponseEntity<ArrayList<InstituicaoFinanceira>> buscarTodos() {
		return new ResponseEntity<ArrayList<InstituicaoFinanceira>>(instituicaoService.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{identifier}")
	public ResponseEntity<InstituicaoFinanceira> buscarPorId(@PathVariable("identifier") Integer id) {
		return new ResponseEntity<InstituicaoFinanceira>(instituicaoService.findById(id), HttpStatus.OK);
	}

	@GetMapping("/nome")
	public ResponseEntity<ArrayList<InstituicaoFinanceira>> buscarPorNome(@RequestParam("nome") String nome) {
		return new ResponseEntity<ArrayList<InstituicaoFinanceira>>(
				(ArrayList<InstituicaoFinanceira>) instituicaoService.findByName(nome), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity inserir(@RequestBody InstituicaoFinanceira instituicao) {
		instituicaoService.save(instituicao);
		return new ResponseEntity(HttpStatus.CREATED);
	}

	@PutMapping("/{identifier")
	public ResponseEntity atualizar(@RequestBody InstituicaoFinanceira instituicao,
			@PathVariable("identifier") Integer id) {
		try {
			instituicaoService.update(id, instituicao);
			return ResponseEntity.status(HttpStatus.OK).body(instituicao);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Instituição não existe.");
		}
	}

}
