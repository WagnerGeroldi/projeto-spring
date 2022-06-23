package com.projectcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcrud.entities.Grade;

public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
