package com.was.udemyrestfull.restfull.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.was.udemyrestfull.restfull.model.Pessoa;
import com.was.udemyrestfull.restfull.services.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService services;
	
	@GetMapping(produces = {"application/json", "application/xml"})
	public List<Pessoa> findAll() {
		return services.findAll();
	}
	
	@GetMapping(value = "/{id}", produces = {"application/json", "application/xml"})
	public Pessoa findById(@PathVariable("id") Long id) {
		return services.findById(id);
	}

	
	@PostMapping(produces = {"application/json", "application/xml"},
				 consumes = {"application/json", "application/xml"})
	public Pessoa create(@RequestBody Pessoa pessoa) {
		return services.create(pessoa);
	}

	@PutMapping(produces = {"application/json", "application/xml"},
				consumes = {"application/json", "application/xml"})
	public Pessoa update(@RequestBody Pessoa pessoa) {
		return services.update(pessoa);
	}
	
	@DeleteMapping
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		services.delete(id);
		return ResponseEntity.ok().build();
	}
}
