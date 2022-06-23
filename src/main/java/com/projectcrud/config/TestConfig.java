package com.projectcrud.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectcrud.entities.Course;
import com.projectcrud.entities.Grade;
import com.projectcrud.entities.Student;
import com.projectcrud.entities.User;
import com.projectcrud.repositories.CourseRepository;
import com.projectcrud.repositories.GradeRepository;
import com.projectcrud.repositories.StudentsRepository;
import com.projectcrud.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GradeRepository gradeRepository;
	
	@Autowired
	StudentsRepository studentsRepository;
	
	@Autowired
	CourseRepository courseRepository;

	@Override
	public void run(String... args) throws Exception {

		User user1 = new User(null, "Wagner Lucas Geroldi", "wagner@gmail.com", "123456");
		
		Student st1 = new Student(null, "João da Silva");
		Student st2 = new Student(null, "Carlos Mendes");
		Student st3 = new Student(null, "Vanessa Carvalho");
		Student st4 = new Student(null, "Miriam Chagas");
		
		
		Course course1 = new Course(null, "QIT", "Qualificação em Informática e Tecnologia" );
		Course course2 = new Course(null, "HHS", "Habilitação em Hardware e Software" );
		Course course3 = new Course(null, "CGE", "Computação Gráfica e Editoração" );
		Course course4 = new Course(null, "EVW", "Edição de Vídeos e WebDesigner" );
		
		Grade grade1 = new Grade(null, 7.0, 6.5, 3.8, 4.6, 8.8, 3.9, st1, course1, null, null);
		Grade grade2 = new Grade(null, 6.0, 7.0, 6.5, 9.8, 6.6, 8.7, st2, course2, null, null);
		Grade grade3 = new Grade(null, 8.0, 6.5, 9.8, 6.6, 8.7, 5.5, st3, course3, null, null);
		Grade grade4 = new Grade(null, 9.0, 9.8, 6.6, 5.7, 5.5, 7.7, st4, course4, null, null);

		userRepository.saveAll(Arrays.asList(user1));
		studentsRepository.saveAll(Arrays.asList(st1,st2,st3,st4));
		courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4));
		gradeRepository.saveAll(Arrays.asList(grade1, grade2, grade3, grade4));

	}

}
