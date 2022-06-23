package com.projectcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectcrud.entities.Grade;
import com.projectcrud.repositories.GradeRepository;

@Service
public class GradeService {
	
	@Autowired
	GradeRepository gradeRepository;
	
	public List<Grade> findAll() {
		return gradeRepository.findAll();
	}
	
	public Optional<Grade> findById(Integer id) {
		Optional<Grade> grade = gradeRepository.findById(id);
		return grade;
	}
	
	public Grade insert(Grade grade) {
		return gradeRepository.save(grade);
	}
	
	public void delete(Integer id) {
		gradeRepository.deleteById(id);
	}
	
}
