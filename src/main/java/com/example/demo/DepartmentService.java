package com.example.demo;

import java.util.List;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getDepartmentList();

	public Department getDepartmentById(int departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(int departmentId);

	public Department updateDepartmentById(int departmentId, Department department);

}
