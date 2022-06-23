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

import com.projectcrud.entities.Student;
import com.projectcrud.services.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentResources {

	@Autowired
	StudentService studentService;

	@GetMapping
	public ResponseEntity<List<Student>> findAll() {

		List<Student> list = studentService.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Student>> findById(@PathVariable Integer id) {

		Optional<Student> student = studentService.findById(id);

		return ResponseEntity.ok().body(student);
	}

	@PostMapping
	public ResponseEntity<Student> insert(@RequestBody Student student) {

		student = studentService.insert(student);
		return ResponseEntity.ok().body(student);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		studentService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
