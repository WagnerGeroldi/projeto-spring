package com.projectcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectcrud.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

}
