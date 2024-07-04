package com.sonny.sa.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sonny.sa.dto.ClientDTO;
import com.sonny.sa.dto.ErrorEntity;
import com.sonny.sa.entites.Client;
import com.sonny.sa.service.ClientService;

import jakarta.persistence.EntityNotFoundException;


@RestController
@RequestMapping(path = "client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;

	
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	public void creer(@RequestBody Client client) {
		
		this.clientService.creer(client);
	}
	
	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public Stream<ClientDTO> rechercher() {
		return this.clientService.rechercher();
	}
	
	@GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
	public Client lire(@PathVariable int id) {
		
		return this.clientService.lire(id);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
	public void modifier(@PathVariable int id, @RequestBody Client client) {
		
		this.clientService.modifier(id, client);
	}
	
}
