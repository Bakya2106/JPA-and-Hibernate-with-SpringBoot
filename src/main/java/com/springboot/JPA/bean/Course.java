package com.springboot.JPA.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Course {

	@Id
	@GeneratedValue
	private long id;
	
	private String course;
	
	@Column(nullable = true)
	private String review;
	
	@ManyToOne//(cascade = {CascadeType.MERGE})
	private Student student;
	
	public Course() {
		
	}
	public  Course( long id) {
		super();
		this.id = id;
		
	}
	public Course(long id, String course) {
		super();
		this.id = id;
		this.course = course;
	
	}
	public Course(long id, String course, String review, Student student) {
		super();
		this.id = id;
		this.course = course;
		this.review = review;
		this.student = student;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", course=" + course + ", review=" + review + "]";
	}
	
	
}
