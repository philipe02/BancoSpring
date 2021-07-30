package com.banco.application.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banco.application.models.Agencia;
import com.banco.application.service.AgenciaService;

@RestController
@RequestMapping("/v1/agencias")
public class AgenciaController {

	@Autowired
	AgenciaService agenciaService;

	@GetMapping
	public ResponseEntity<Page<Agencia>> buscarTodasAgencias(
			@RequestParam(required = false, defaultValue = "0") Integer numeroPagina,
			@RequestParam(required = false, defaultValue = "2") Integer itensPorPagina,
			@RequestParam(required = false, defaultValue = "nome") String campoOrdenacao,
			@RequestParam(required = false, defaultValue = "ASC") String ordemOrdenacao,
			@RequestParam(required = false) Integer id, @RequestParam(required = false) String nome) {
		return new ResponseEntity<Page<Agencia>>(
				agenciaService.buscarTodas(numeroPagina, itensPorPagina, campoOrdenacao, ordemOrdenacao, id, nome),
				HttpStatus.OK);
	}

	@GetMapping("/filtros")
	public ResponseEntity<ArrayList<Agencia>> buscarAgenciasFiltro(@RequestParam("id") Integer id,
			@RequestParam("nome") String nome) {

		return ResponseEntity.ok(agenciaService.buscarPorFiltroSpecification(id, nome));
	}

}
