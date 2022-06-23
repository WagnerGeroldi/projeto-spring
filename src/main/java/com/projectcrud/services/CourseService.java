package com.projectcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectcrud.entities.Course;
import com.projectcrud.repositories.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<Course> findAll() {
		return courseRepository.findAll();
	}
	
	public Optional<Course> findById(Integer id) {
		Optional<Course> course = courseRepository.findById(id);
		return course;
	}
	
	public Course insert(Course course) {
		return courseRepository.save(course);
	}
	
	public void delete(Integer id) {
		courseRepository.deleteById(id);
	}
	
}
