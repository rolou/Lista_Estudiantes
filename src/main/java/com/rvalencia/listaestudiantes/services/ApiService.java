package com.rvalencia.listaestudiantes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rvalencia.listaestudiantes.models.Contact;
import com.rvalencia.listaestudiantes.models.Student;
import com.rvalencia.listaestudiantes.repositories.ContactRepo;
import com.rvalencia.listaestudiantes.repositories.StudentRepo;

@Service
public class ApiService {

	@Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ContactRepo contactRepo;

    public List<Student> findByContactIsNull() {
        return studentRepo.findByContactIsNull();
    }

    public List<Student> findByContactNotNull() {
        return studentRepo.findByContactNotNull();
    }

    public List<Contact> findAllContactInfo() {
        return contactRepo.findAll();
    }

    public Student createStudent(String firstName, String lastName, int age) {
        Student student = new Student(firstName, lastName, age);
        studentRepo.save(student);
        return student;
    }

    public Contact createContact(Long studentId, String address, String city, String state) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        if (optionalStudent.isPresent()) {
            Contact contact = new Contact(address, city, state, optionalStudent.get());
            contactRepo.save(contact);
            return contact;
        }
        return null;
    }
}
