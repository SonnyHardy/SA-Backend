package com.sonny.sa.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sonny.sa.entites.Sentiment;
import com.sonny.sa.enums.TypeSentiment;
import com.sonny.sa.service.SentimentService;

import lombok.AllArgsConstructor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.HttpStatus;


@RestController
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class SentimentController {
	
	private SentimentService sentimentService;

	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	public void creer(@RequestBody Sentiment sentiment) {
		this.sentimentService.creer(sentiment);
	}
	
	@GetMapping
	public @ResponseBody List<Sentiment> rechercher(@RequestParam(required = false) TypeSentiment type) {
		return this.sentimentService.rechercher(type);
	}
	
	@GetMapping(path = "{client_id}")
	public @ResponseBody List<Sentiment> lire(@PathVariable int client_id, @RequestParam(required = false) TypeSentiment type) {
		
		return this.sentimentService.lire(client_id, type);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "{id}")
	public void supprimer(@PathVariable int id) {
		this.sentimentService.supprimer(id);
	}
}
