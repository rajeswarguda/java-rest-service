package com.javarestservice.java_rest_service.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/matrixVariableDemo")
public class MatrixVariableController {

	// http://localhost:8080/matrixVariableDemo/contacts/contactNo=1234

	@RequestMapping(value = "/contacts/{contactNo}", method = RequestMethod.GET)
	public String getContactNo(@MatrixVariable String contactNo) {
		return contactNo;
	}

	// http://localhost:8080/matrixVariableDemo/employees/John;beginContactNumber=22001

	@RequestMapping(value = "/employees/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getEmployeeByNameAndBeginContactNumber(@PathVariable String name,
			@MatrixVariable String beginContactNumber) {

		return Arrays.asList(name, beginContactNumber);
	}

	// http://localhost:8080/matrixVariableDemo/employeeData/id=1;name=John;contactNumber=2200112334

	@GetMapping("employeeData/{employee}")
	@ResponseBody
	public ResponseEntity<Map<String, String>> getEmployeeData(@MatrixVariable Map<String, String> matrixVars) {
		return new ResponseEntity<>(matrixVars, HttpStatus.OK);
	}

	// http://localhost:8080/matrixVariableDemo/companyEmployee/id=2;name=Xpto/employeeData/id=1;name=John;contactNumber=2200112334

	@RequestMapping(value = "/companyEmployee/{company}/employeeData/{employee}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, String>> getEmployeeDataFromCompany(
			@MatrixVariable(pathVar = "employee") Map<String, String> matrixVars) {
		return new ResponseEntity<>(matrixVars, HttpStatus.OK);
	}

	// http://localhost:8080/matrixVariableDemo/Employee/id=2;name=Xpto/employeeData/id=1;name=John;contactNumber=2200112334

	@RequestMapping(value = "/Employee/{company}/employeeData/{employee}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getEmployeeNameFromCompany(
			@MatrixVariable(value = "name", pathVar = "employee") String name) {
		return new ResponseEntity<>(name, HttpStatus.OK);
	}

	// http://localhost:8080/matrixVariableDemo/allContacts

	@RequestMapping(value = "/allContacts", method = RequestMethod.GET)
	public List<String> allContacts() {
		return Arrays.asList("123", "156");
	}

}
