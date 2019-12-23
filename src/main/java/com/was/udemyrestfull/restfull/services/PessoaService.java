package com.was.udemyrestfull.restfull.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.was.udemyrestfull.restfull.exception.ResouceNotFoundException;
import com.was.udemyrestfull.restfull.model.Pessoa;
import com.was.udemyrestfull.restfull.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public Pessoa findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResouceNotFoundException("Não encontrado registro com este ID"));
	}
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public Pessoa create(Pessoa pessoa) {
		return repository.save(pessoa);
	}

	public Pessoa update(Pessoa pessoa) {
		Pessoa entity = findById(pessoa.getId());
				
		entity.setNome(pessoa.getNome());
		entity.setSobreNome(pessoa.getSobreNome());
		entity.setEndereco(pessoa.getEndereco());
		entity.setGenero(pessoa.getGenero());
		return repository.save(entity);
	}
	
	public void delete(Long id) {
		Pessoa entity = findById(id);
		repository.delete(entity);
	}
}
