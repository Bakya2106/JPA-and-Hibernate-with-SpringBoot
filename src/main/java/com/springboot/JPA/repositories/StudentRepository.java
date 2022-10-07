package com.springboot.JPA.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.springboot.JPA.bean.Clubs;
import com.springboot.JPA.bean.Course;
import com.springboot.JPA.bean.IDProof;
import com.springboot.JPA.bean.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
		@PersistenceContext
		EntityManager em; //interface to persistancecontext
		
		public Student findbyId(long id) {
			return em.find(Student.class, id);
		}
		
		public void deletebyId(int id) {
			Student stu= em.find(Student.class, id);
			em.remove(stu);
		}
		
		@Transactional //override the class level @Transactional 
		public void savestudentwithId() {
	         
		   IDProof idp=new IDProof(345676L);
	       em.persist(idp);
	       Student stu=new Student("Keerthiga");
	       stu.setIdp(idp);
	       em.persist(stu);
		
		}
		
		public void saveCoursewithStudent() {
			Student s=findbyId(2001L);
			Course c= em.find(Course.class, 221L);
			s.addCourse(c);
			c.setStudent(s);;
			em.persist(s);
			
			
		}
		
		public void addListofcourse() {
			List <Course> course= new ArrayList<Course>();
			course.add(new Course(11L, "REACT JS"));
			course.add(new Course(15L,"NODE JS"));
			Student s=findbyId(2001L);
			for(Course c:course)
			{			
				//setting the relationship
              s.addCourse(c);				
              c.setStudent(s);
				em.merge(c);
			}
			
			/*
			 * Student s=findbyId(2001L); Course c1 = new Course(11L, "REACT JS"); Course c2
			 * = new Course(12L, "NODE JS");
			 * 
			 * //setting the relationship s.addCourse(c1); c1.setStudent(s);
			 * s.addCourse(c2); c2.setStudent(s);
			 * 
			 * em.merge(c1); em.merge(c2);
			 */ //Persist should be called only on new entities, while merge is meant to reattach detached entities. 
		}
		
		
		 
		 
		
		public void getStudentwithClub() {
			Student s=findbyId(2002L);
			logger.info("output -> {}",s.getClubs());
			
		}
		
		@Transactional
		public void insertStudentwithClub() {
			Clubs c=em.find(Clubs.class, 2L);
			Student s=new Student("Gayathri");
			s.addClubs(c);
			c.setoneStudent(s);
			em.persist(s);
			//s.addClubs(c);
			//c.setoneStudent(s);
			//em.persist(s);
		}
}
