package com.javarestservice.java_rest_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javarestservice.java_rest_service.models.Course;
import com.javarestservice.java_rest_service.models.Student;

@Service
public class StudentService {
	
	private List<Student> students;

	public StudentService() {
		super();
		
		this.students = new ArrayList<>();
		this.students.add(new Student(1, "Rajeswar", "7777777777", new Course(1, "Java", "online")));
		this.students.add(new Student(2, "Sreedevi", "9999999999", new Course(1, "Spring", "offline")));
	}
	
	public List<Student> getStudents() {
		return this.students;
	}
	
	public Student getStudent(int id) {
		 Optional<Student> first = this.students.stream().filter( student -> student.getId() == id).findFirst();
		 return first.isPresent() ? first.get() : null;
	}
	
	

}
