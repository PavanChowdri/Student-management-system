package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Student;
import com.example.demo.services.StudentServices;

@Controller
public class StudentController {
	
	@Autowired
	StudentServices service;
	@PostMapping("/reg")
	public String addStudent(Student st) {
		service.addStudent(st);
		return "index";
	}
	
	
	@PostMapping("/update")
	String updateStudent(Student st) {
		service.updateStudent(st);
		return "index";
	}
	
	@PostMapping("/del")
	String deleteStudent(int univId) {
		service.deleteStudent(univId);
		return "index";
	}
	
	@PostMapping("/search")
	String searchStudent(int univId,Model m) {
		Student s= service.searchStudent(univId);
		m.addAttribute("student",s);
		return "DisplayStudent";
	}
	
	@GetMapping("/fetchAll")
	String fetchStudent(Model m) {
		java.util.List<Student> sList=service.fetchAllStudent();
		m.addAttribute("stList",sList);
		return "DisplayAllStudents";		
		
		
	}
	
	

}
