package com.javarestservice.java_rest_service.models;

public class Course {
	private int id;
	private String name;
	private String type;
	
	public Course(int id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", type=" + type + "]";
	}
	
	
	
	

}
