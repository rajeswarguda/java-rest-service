package com.javarestservice.java_rest_service.models;

public class Student {
	
	private int id;
	private String name;
	private String mobile;
	private Course course;
	
	public Student(int id, String name, String mobile, Course course) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.course = course;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}

	public Course getCourse() {
		return course;
	}
	
}
