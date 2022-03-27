package com.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    StudentRepository studentrepo;

    @Autowired
    CourseRepository courserepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		Course CompilerDesign = new Course("CD", "Compiler Design");
		Course CloudComputing = new Course("CC", "Cloud Computing");
		Course OOAD = new Course("OOAD", "Object Oriented Analysis and Design");
		Course GP = new Course("GP", "Generic Programming");
		Course WebTech = new Course("WT", "Web Tech");
		Course DBT = new Course("DBT", "Database Technologies");
		Course DAA = new Course("DAA", "Design and analysis of Algo");
		Course OS = new Course("OS", "Operating systems");
		Course MPCA = new Course("MPCA", "MicroProcessor");
		Course CN = new Course("CN", "Computer Networks");

		courserepo.save(CompilerDesign);
		courserepo.save(CloudComputing);
		courserepo.save(OOAD);
		courserepo.save(GP);
		courserepo.save(WebTech);
		courserepo.save(DBT);
		courserepo.save(DAA);
		courserepo.save(OS);
		courserepo.save(MPCA);
		courserepo.save(CN);

		List<Student> students = new LinkedList<Student>();
		students.add(new Student("Jane", "Doe", "PES1UG19CS323", 
				Arrays.asList(new Course[] { CompilerDesign, CloudComputing })));
		students.add(new Student("Mark", "Sloan", "PES1UG19CS583", 
				Arrays.asList(new Course[] { OOAD, GP })));
		students.add(new Student("Michael", "Williams", "PES1UG19CS113", 
				Arrays.asList(new Course[] { WebTech, DBT })));
		students.add(new Student("Anna", "Miller", "PES1UG19CS150", 
				Arrays.asList(new Course[] { DAA, OS, MPCA })));
		students.add(new Student("Susan", "Brown", "PES1UG19CS656", 
				Arrays.asList(new Course[] { CN })));
		studentrepo.saveAll(students);
	}

}
