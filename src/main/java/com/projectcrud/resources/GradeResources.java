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

import com.projectcrud.entities.Grade;
import com.projectcrud.services.GradeService;

@RestController
@RequestMapping(value = "/grade")
public class GradeResources {

	@Autowired
	GradeService gradeService;

	@GetMapping
	public ResponseEntity<List<Grade>> findAll() {

		List<Grade> list = gradeService.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Grade>> findById(@PathVariable Integer id) {

		Optional<Grade> grade = gradeService.findById(id);

		return ResponseEntity.ok().body(grade);
	}

	@PostMapping
	public ResponseEntity<Grade> insert(@RequestBody Grade grade) {

		grade = gradeService.insert(grade);
		return ResponseEntity.ok().body(grade);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		gradeService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
