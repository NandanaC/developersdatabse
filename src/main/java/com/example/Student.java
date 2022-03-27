package com.example;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	public String srn;
	@ManyToMany
	private List<Course> course;

	public Student() {
		super();
	}

	public Student(String firstName, String lastName, String srn,
			List<Course> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.srn = srn;
		this.course = courses;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSRN() {
		return srn;
	}

	public void setSRN(String srn) {
		this.srn = srn;
	}

	public List<Course> getCourses() {
		return course;
	}

	public void setCourses(List<Course> courses) {
		this.course = course;
	}

	public boolean hasCourse(Course course) {
		for (Course containedCourse: getCourses()) {
			if (containedCourse.getId() == course.getId()) {
				return true;
			}
		}
		return false;
	}

}