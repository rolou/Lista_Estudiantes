package com.rvalencia.listaestudiantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rvalencia.listaestudiantes.models.Contact;
import com.rvalencia.listaestudiantes.models.Student;
import com.rvalencia.listaestudiantes.services.ApiService;

@Controller
public class ApiController {

	@Autowired
    private ApiService apiService;

    @GetMapping("/students/create")
    public String createNewStudent(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("age") Integer age
    ) {
        if (firstName.isBlank()) {
            return "error";
        }
        Student student = apiService.createStudent(firstName.trim(), lastName, age);
        return "Success";
    }

    @GetMapping("/contact/create")
    public Contact createNewContact(
            @RequestParam("student") Long studentId,
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("state") String state
    ) {
        System.out.println(studentId + " " + address + " " + city + " " + state);
        Contact contact = apiService.createContact(studentId, address, city, state);
        return contact;
    }
}
