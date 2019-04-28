package com.andremorita.java.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andremorita.java.domain.Cidade;
import com.andremorita.java.repositories.CidadeRepository;
import com.andremorita.java.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository repository;

	public Cidade find(Integer id) {
		Optional<Cidade> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! CidadeId: " + id ));
	}
}
