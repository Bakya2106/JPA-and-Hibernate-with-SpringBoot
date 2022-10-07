package com.springboot.JPA.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Clubs {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String clubname;

	@ManyToMany(mappedBy ="clubs" ,fetch = FetchType.EAGER)
	private List<Student> student=new ArrayList<Student>();
	
	
	public Clubs() {
		super();
	}

	public Clubs(long id, String clubname) {
		super();
		this.id = id;
		this.clubname = clubname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getClubName() {
		return clubname;
	}

	public void setClubName(String clubName) {
		this.clubname = clubName;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public void setoneStudent(Student student) {
		this.student.add(student);
	}

	@Override
	public String toString() {
		return "Clubs [id=" + id + ", clubname=" + clubname + ", student=" + student + "]";
	}
	
	
	
}
