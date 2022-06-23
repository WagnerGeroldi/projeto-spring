package com.projectcrud.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectcrud.entities.Course;
import com.projectcrud.services.CourseService;

@RestController
@RequestMapping(value = "/course")
public class CourseResources {

	@Autowired
	CourseService courseService;

	@GetMapping
	public ResponseEntity<List<Course>> findAll() {

		List<Course> list = courseService.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Course>> findById(@PathVariable Integer id) {

		Optional<Course> course = courseService.findById(id);

		return ResponseEntity.ok().body(course);
	}

	@PostMapping
	public ResponseEntity<Course> insert(@RequestBody Course course) {

		course = courseService.insert(course);
		return ResponseEntity.ok().body(course);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		courseService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
