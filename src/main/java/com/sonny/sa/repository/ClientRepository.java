package com.sonny.sa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sonny.sa.entites.Client;


public interface ClientRepository extends JpaRepository<Client, Integer>{

	Client findByEmail(String email);
}
