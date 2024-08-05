package com.sonny.sa.service;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.sonny.sa.dto.ClientDTO;
import com.sonny.sa.entites.Client;
import com.sonny.sa.mapper.ClientDTOMapper;
import com.sonny.sa.repository.ClientRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {
	
	
	private ClientRepository clientRepository;
	private ClientDTOMapper clientDTOMapper;

	public void creer(Client client) {
		Client clientBDD = this.clientRepository.findByEmail(client.getEmail());
		if(clientBDD == null) {
			this.clientRepository.save(client);
			System.out.println("Creation reussie !");
		}
	}
	
	public Stream<ClientDTO> rechercher() {
		return this.clientRepository.findAll()
				.stream().map(this.clientDTOMapper);
		
	}

	public Client lire(int id) {
		Optional<Client> optionalClient = this.clientRepository.findById(id);
		return optionalClient.orElseThrow(
				() -> new EntityNotFoundException("Aucun client n'existe avec cet id"));
	}

	public Client lireOuCreer(Client clientACreer) {
		
		Client clientBDD = this.clientRepository.findByEmail(clientACreer.getEmail());
		if(clientBDD == null) {
			clientBDD = this.clientRepository.save(clientACreer);
		}
		return clientBDD;
	}

	public void modifier(int id, Client client) {
		
		Client clientBDD = this.lire(id);
		if (clientBDD.getId() == client.getId()) {
			clientBDD.setEmail(client.getEmail());
			clientBDD.setTelephone(client.getTelephone());
			this.clientRepository.save(clientBDD);
		}
	}
}
