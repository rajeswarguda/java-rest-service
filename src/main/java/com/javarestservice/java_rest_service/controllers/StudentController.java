package com.javarestservice.java_rest_service.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javarestservice.java_rest_service.models.Student;
import com.javarestservice.java_rest_service.service.StudentService;

@RestController
@RequestMapping("/StudentService/V1")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// http://localhost:8080/StudentService/V1/students
	@GetMapping("/students")
	public List<Student> getStudents() {

		return studentService.getStudents();
	}

	// http://localhost:8080/StudentService/V1/student/V1/2
	@GetMapping("/student/{version}/{id}")
	public Student getStudent(@PathVariable(name = "id") int id, @PathVariable(name = "version") String version) {
		System.out.println("vesrion : " + version);
		return studentService.getStudent(id);
	}

	// http://localhost:8080/StudentService/V1/student?sid=2
	@GetMapping("/student")
	public Student fetchStudent(@RequestParam(name = "sid", required = true, defaultValue = "1") int id) {
		return studentService.getStudent(id);
	}

	// http://localhost:8080/StudentService/V1/queryParam?ids=1,2
	// http://localhost:8080/StudentService/V1/queryParam?ids=1&ids=2
	@GetMapping("/queryParam")
	public List<String> pathVariable(@RequestParam List<String> ids) {
		return ids;
	}

	// http://localhost:8080/StudentService/V1/allParams?id=1&name=rajesh&mobile=999999999
	@GetMapping("/allParams")
	public Map<String, String> allQueryParams(@RequestParam Map<String, String> params) {
		return params;
	}

	// http://localhost:8080/StudentService/V1/headers

	/*
	 * X-Request-ID:f058ebd6-02f7-4d3f-942e-904344e8cde5
	 * X-Correlation-ID:f058ebd6-02f7-4d3f-942e-904344e8cde5
	 * 
	 */
	@PostMapping(value = "/headers")
	public Map<String, String> allHeaders(@RequestHeader Map<String, String> headers) {
		return headers;
	}
	
	// http://localhost:8080/StudentService/V1/reqHeader
	@PostMapping(value = "/reqHeader")
	public String getHeader(@RequestHeader(value="X-Request-ID", required = false) String requestId) {
		return requestId;
	}

}
