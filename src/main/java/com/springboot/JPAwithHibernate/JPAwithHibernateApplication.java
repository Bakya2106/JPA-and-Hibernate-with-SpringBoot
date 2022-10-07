package com.springboot.JPAwithHibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.springboot.JPA.repositories.StudentRepository;


@SpringBootApplication
@ComponentScan("com")
@EntityScan(basePackages = {"com.springboot.JPA.bean"})
public class JPAwithHibernateApplication  implements CommandLineRunner{
	
	
	
	@Autowired
	private StudentRepository sturep;
	
	public static void main(String[] args) {
		SpringApplication.run(JPAwithHibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		sturep.savestudentwithId();
        sturep.saveCoursewithStudent();
        
		sturep.addListofcourse();
        sturep.getStudentwithClub();
        sturep.insertStudentwithClub();
	}

	
}
