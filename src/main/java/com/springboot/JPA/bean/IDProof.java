package com.springboot.JPA.bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class IDProof {

	@Id
	private long id;
	private String idproof;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "idp")
	private Student student; //owning side of relationship ->STUDENT ie. IDProof will not have student id 
	//but bi-directional navigation is possible 
	
	public IDProof() {
		super();
	}


	public IDProof(long id) {
		super();
		this.id = id;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getIdproof() {
		return idproof;
	}


	public void setIdproof(String idproof) {
		this.idproof = idproof;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	@Override
	public String toString() {
		return "IDProof [id=" + id + ", idproof=" + idproof + "]";
	}
	
	

	
	
	
	
}
