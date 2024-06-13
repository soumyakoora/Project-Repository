package com.example.datajpajoins;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeService {
@Autowired
EmployeeRepository employeeRepository;

public Employee saveEmployee(Employee employee) {
	return employeeRepository.save(employee);
}

public List<Employee> getEmployees()
{
	return employeeRepository.findAll();
}

public Employee getEmployeeById(Long empId) {
	return employeeRepository.findByEmpId(empId);
}
public List<Employee> deleteEmployeeByDesignation(String designation)
{
	return employeeRepository.deleteByDesignation(designation);
}

public Employee getEmployeesByDesignation(String designation) {
	return employeeRepository.getEmployeesByDesignation(designation);
}

//this method is for paging, controller request is same for below method also.below methods is sorting records with name.
/*public Page<Employee> getEmployeePagination(int pageNumber, int pageSize) {
	Pageable pageable= PageRequest.of(pageNumber, pageSize);
	return employeeRepository.findAll(pageable);
}*/
public Page<Employee> getEmployeePagination(int pageNumber, int PageSize){
	Sort sort= Sort.by(Sort.Direction.ASC, "name");
	Pageable pageable=PageRequest.of(pageNumber, PageSize, sort);
	return employeeRepository.findAll(pageable);
}
public Page<Employee> getEmployeePagination(int pageNumber, int PageSize, String sortProperty)
{
	PageRequest  pageable = null;
	if(null!=sortProperty)
	{
		pageable = PageRequest.of(pageNumber, PageSize, Sort.Direction.DESC,sortProperty);
	}
	else
	{
		pageable = PageRequest.of(pageNumber, PageSize, Sort.Direction.DESC,"name");
	}
	return employeeRepository.findAll(pageable);
}
}