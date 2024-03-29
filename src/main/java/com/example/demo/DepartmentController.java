package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentService departmentservice;
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return departmentservice.saveDepartment(department);
	}
	
	@GetMapping("/departments")
	public List<Department> getDepartmentList() {
		return departmentservice.getDepartmentList();
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable("id") int departmentId) throws DepartmentNotFoundException {
		return departmentservice.getDepartmentById(departmentId);
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id") int departmentId) {
		departmentservice.deleteDepartmentById(departmentId);
		return "Department Deleted Successfully....";
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartmentById(@PathVariable("id") int departmentId,@RequestBody Department department) {
		return departmentservice.updateDepartmentById(departmentId,department);
	}
}
