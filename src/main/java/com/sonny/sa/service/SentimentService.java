package com.sonny.sa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sonny.sa.entites.Client;
import com.sonny.sa.entites.Sentiment;
import com.sonny.sa.enums.TypeSentiment;
import com.sonny.sa.repository.ClientRepository;
import com.sonny.sa.repository.SentimentRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class SentimentService {
	
	private SentimentRepository sentimentRepository;
	private ClientService clientService;
	private ClientRepository clientRepository;
	
	
	public void creer(Sentiment sentiment) {
		Client client = this.clientService.lireOuCreer(sentiment.getClient());
		sentiment.setClient(client);
		
		// Analyse
		if(sentiment.getTexte().contains("pas")) {
			sentiment.setType(TypeSentiment.NEGATIF);
		}else {
			sentiment.setType(TypeSentiment.POSITIF);
		}
		this.sentimentRepository.save(sentiment);
	}

	
	public List<Sentiment> rechercher(TypeSentiment type) {
		if(type == null) {
			return this.sentimentRepository.findAll();
		}else {
			return this.sentimentRepository.findByType(type);
		}
		
	}
	
	public List<Sentiment> lire(int client_id, TypeSentiment type) {
		Optional<Client> clientBDD = clientRepository.findById(client_id);
			if (clientBDD.isPresent()) {
				if (type == null) {
					return this.sentimentRepository.findByClient(clientBDD);
				}else {
					return this.sentimentRepository.findByClientAndType(clientBDD, type);
				}
				
			}else {
				return null;
			}
			
	}

	public void supprimer(int id) {
		this.sentimentRepository.deleteById(id);
		
	}
	
	
}
