package com.projectcrud.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_grade")
public class Grade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	Double gradeStageI;
	Double gradeStageII;
	Double gradeStageIII;
	Double gradeStageIV;
	Double gradeStageV;
	Double gradeStageVI;
	Double average;
	String result;

	@OneToOne
	Student student;

	@OneToOne
	@JoinColumn(name = "course_id", referencedColumnName = "id")
	Course course;

	public Grade() {
	}

	public Grade(Integer id, Double gradeStageI, Double gradeStageII, Double gradeStageIII, Double gradeStageIV,
			Double gradeStageV, Double gradeStageVI, Student student, Course course, Double average, String result) {
		super();
		this.id = id;
		this.gradeStageI = gradeStageI;
		this.gradeStageII = gradeStageII;
		this.gradeStageIII = gradeStageIII;
		this.gradeStageIV = gradeStageIV;
		this.gradeStageV = gradeStageV;
		this.gradeStageVI = gradeStageVI;
		this.student = student;
		this.course = course;
		this.average = getAverage();
		this.result = getResult();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getGradeStageI() {
		return gradeStageI;
	}

	public void setGradeStageI(Double gradeStageI) {
		this.gradeStageI = gradeStageI;
	}

	public Double getGradeStageII() {
		return gradeStageII;
	}

	public void setGradeStageII(Double gradeStageII) {
		this.gradeStageII = gradeStageII;
	}

	public Double getGradeStageIII() {
		return gradeStageIII;
	}

	public void setGradeStageIII(Double gradeStageIII) {
		this.gradeStageIII = gradeStageIII;
	}

	public Double getGradeStageIV() {
		return gradeStageIV;
	}

	public void setGradeStageIV(Double gradeStageIV) {
		this.gradeStageIV = gradeStageIV;
	}

	public Double getGradeStageV() {
		return gradeStageV;
	}

	public void setGradeStageV(Double gradeStageV) {
		this.gradeStageV = gradeStageV;
	}

	public Double getGradeStageVI() {
		return gradeStageVI;
	}

	public void setGradeStageVI(Double gradeStageVI) {
		this.gradeStageVI = gradeStageVI;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Double getAverage() {

		return average = (gradeStageI + gradeStageII + gradeStageIII + gradeStageIV + gradeStageV + gradeStageVI) / 6;

	}

	public String getResult() {
		if (average > 6) {
			return result = "Aprovado";
		} else {
			return result = "Reprovado";
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grade other = (Grade) obj;
		return Objects.equals(id, other.id);
	}

}
