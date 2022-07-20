package com.supercopo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supercopo.domain.model.Cliente;
import com.supercopo.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class ClienteController {
	
	private ClienteRepository clienteRepository; 
	
	//mostrando um lista de clientes primeira requisição
	//Arrys.asList- mostra a lista de forma que vc escolhe
	@GetMapping("/clientes")
	public List<Cliente>listar() {
		return clienteRepository.findByNomeContaining("a");
		
	}
	
}
