package com.rvalencia.listaestudiantes.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rvalencia.listaestudiantes.models.Student;

public interface StudentRepo extends CrudRepository<Student, Long> {

	 	List<Student> findAll();
	    List<Student> findByContactIsNull();
	    List<Student> findByContactNotNull();
}
