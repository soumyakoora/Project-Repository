package com.example.datajpajoins;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/saveEmployees")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/getEmployee")
	public List<Employee> getEmployee()
	{
		return employeeService.getEmployees();
	}
	
	@GetMapping("/getEmployeeById/{empId}")
	public Employee getEmployees(@PathVariable Long empId)
	{
		return employeeService.getEmployeeById(empId);
	}
	
	@DeleteMapping("/deleteEmployeeByDesignation/{designation}")
	public List<Employee> deleteEmployeeByDesignation(@PathVariable String designation)
	{
		return employeeService.deleteEmployeeByDesignation(designation);
	}
	@GetMapping("/getEmployeeByDesignation/{designation}")
	public Employee getEmployeesByDesignation(@PathVariable String designation)
	{
		return employeeService.getEmployeesByDesignation(designation);
	}
	@RequestMapping(value="/pagingAndSortingEmployees/{pageNumber}/{pageSize}", method=RequestMethod.GET)
	public Page<Employee> employeePagination(@PathVariable int pageNumber, @PathVariable int pageSize)
	{
		return employeeService.getEmployeePagination(pageNumber,pageSize);
	}
	@RequestMapping(value="/pagingAndSortingEmployees/{pageNumber}/{pageSize}/{sortProperty}", method=RequestMethod.GET)
	public Page<Employee> employeePagination(@PathVariable int pageNumber, @PathVariable int pageSize ,@PathVariable String sortProperty)
	{
		return employeeService.getEmployeePagination(pageNumber,pageSize);
	}
}
