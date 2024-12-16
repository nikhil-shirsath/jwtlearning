package com.example.springsecuritylearn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecuritylearn.Entity.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	private List<Student> students = new ArrayList<>(List.of(
			new Student(1,"nikhil",22),
			new Student(2,"shubham",44)));

	@GetMapping("/students")
	public List greetStudent() {
		return students;
	}
	
	@GetMapping("csrf-token")
	public CsrfToken getCsrfToken(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
	
	@PostMapping("/students")
	public boolean addStudent(@RequestBody Student obj) {
		
		return students.add(obj);
	}
}
