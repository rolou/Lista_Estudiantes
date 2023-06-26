package com.rvalencia.listaestudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rvalencia.listaestudiantes.models.Contact;

public interface ContactRepo extends CrudRepository<Contact, Long>{
	List<Contact> findAll();
}
