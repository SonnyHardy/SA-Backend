package com.sonny.sa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonny.sa.entites.Client;
import com.sonny.sa.entites.Sentiment;
import com.sonny.sa.enums.TypeSentiment;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer>{

	List<Sentiment> findByType(TypeSentiment type);
	List<Sentiment> findByClient(Optional<Client> client);
	List<Sentiment> findByClientAndType(Optional<Client> client, TypeSentiment type);
}
