package com.sonny.sa.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.sonny.sa.dto.ClientDTO;
import com.sonny.sa.entites.Client;


@Component
public class ClientDTOMapper implements Function<Client, ClientDTO>{

	@Override
	public ClientDTO apply(Client client) {
		
		return new ClientDTO(client.getId(), client.getEmail(), client.getTelephone());
	}

	
}
