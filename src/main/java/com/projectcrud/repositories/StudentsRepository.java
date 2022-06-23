package com.projectcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcrud.entities.Student;

public interface StudentsRepository extends JpaRepository<Student, Integer> {

}
