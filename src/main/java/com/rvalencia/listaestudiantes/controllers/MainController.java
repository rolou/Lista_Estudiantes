package com.rvalencia.listaestudiantes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rvalencia.listaestudiantes.services.ApiService;

@RestController
public class MainController {

	 @Autowired
	    private ApiService apiService;

	    @GetMapping("/")
	    public String index() {
	        return "index.jsp";
	    }

	    @GetMapping("/students/new")
	    public String newStudent() {
	        return "students.jsp";
	    }

	    @GetMapping("/contact/new")
	    public String newContact(Model model) {
	        model.addAttribute(
	                "studentsList",
	                apiService.findByContactIsNull()
	        );
	        return "contact.jsp";
	    }

	    @GetMapping("/students")
	    public String showDetails(Model model) {
	        model.addAttribute(
	                "studentsList",
	                apiService.findByContactNotNull()
	        );
	        return "details.jsp";
	    }
	
}
