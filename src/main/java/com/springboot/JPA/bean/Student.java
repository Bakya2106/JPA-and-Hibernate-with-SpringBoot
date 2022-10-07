package com.springboot.JPA.bean;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	private IDProof idp; 
	
	@OneToMany(mappedBy = "student")//,fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
	private List<Course> course=new ArrayList<Course>();
	
	@ManyToMany(cascade = {CascadeType.MERGE})
//	Customizing join table
// @JoinTable(name = "STUDENT_CLUBS_TABLE",
//	joinColumns = @JoinColumn(name="STUDENT_ID"),
//	inverseJoinColumns = @JoinColumn(name="CLUBS_ID")
//			)
    private List<Clubs> clubs=new ArrayList<Clubs>();
    
	public Student() {
		super();
	}
	
	public Student(long id) {
		super();
		this.id = id;
	}
	
	public Student (String name) {
		super();
		this.name=name;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public IDProof getIdp() {
		return idp;
	}
	public void setIdp(IDProof idp) {
		this.idp = idp;
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	public void addCourse(Course c) {
		 course.add(c);
	}
	
	public void addCourse(List<Course> c) {
		 course.addAll(c);
	}
	public void removeCourse(Course c) {
		 course.remove(c);
	
	}

	public List<Clubs> getClubs() {
		return clubs;
	}

	public void addClubs(Clubs clubs) {
		this.clubs.add(clubs);
		}
	
	
	
}
