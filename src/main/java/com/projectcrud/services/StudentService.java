package com.projectcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectcrud.entities.Student;
import com.projectcrud.repositories.StudentsRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentsRepository studentsRepository;
	
	public List<Student> findAll() {
		return studentsRepository.findAll();
	}
	
	public Optional<Student> findById(Integer id) {
		Optional<Student> student = studentsRepository.findById(id);
		return student;
	}
	
	public Student insert(Student user) {
		return studentsRepository.save(user);
	}
	
	public void delete(Integer id) {
		studentsRepository.deleteById(id);
	}
	
}
