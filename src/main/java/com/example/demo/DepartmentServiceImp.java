package com.example.demo;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImp implements DepartmentService{
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> getDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department getDepartmentById(int departmentId) throws DepartmentNotFoundException {
		Optional<Department> department= departmentRepository.findById(departmentId);
		if (!department.isPresent()) {
			throw new DepartmentNotFoundException("Department not available");
		}
		return department.get();
	}

	@Override
	public void deleteDepartmentById(int departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartmentById(int departmentId, Department department) {
		Department depDB = departmentRepository.findById(departmentId).get();
		if(Objects.nonNull(department.getDepartmentName())&&!"".equals(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		
		if(Objects.nonNull(department.getDepartmentAddress())&&!"".equals(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		
		if(Objects.nonNull(department.getDepartmentCode())&&!"".equals(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepository.save(depDB);
	}
}
