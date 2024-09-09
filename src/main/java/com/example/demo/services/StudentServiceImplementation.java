package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentServices {

	@Autowired
	StudentRepository repo;
	
	@Override
	public String addStudent(Student st) {
		repo.save(st);
		return "student added successfully";
	}
	
	@Override
	public String updateStudent(Student st) {
		repo.save(st);
		return "student updated successfully";
	}
	
	@Override
	public String deleteStudent(int univId) {
		repo.deleteById(univId);
		return "student Deleted successfully";
	}

	@Override
	public Student searchStudent(int univId) {
		return repo.findById(univId).get();

	}

	@Override
	public List<Student> fetchAllStudent() {
		return repo.findAll();
	}
	

}
