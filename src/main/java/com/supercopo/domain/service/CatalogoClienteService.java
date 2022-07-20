package com.supercopo.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.supercopo.domain.NegocioException;
import com.supercopo.domain.model.Cliente;
import com.supercopo.repository.ClienteRepository;

@Service
public class CatalogoClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente salvar(Cliente cliente) {
		boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
						.stream()
						.anyMatch(clienteExixtente -> !clienteExixtente.equals(cliente));
		
		if(emailEmUso) {
			throw new NegocioException("Já exixte um cliente cadastro com este e-mail.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	@Transactional
	public void remover(Long clienteId) {
		clienteRepository.deleteById(clienteId);
	}
}
