package com.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
	public List<Course> findByLabel(String label);
}
