package com.example.datajpajoins;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
  Employee findByEmpId(Long id);
  List<Employee> deleteByDesignation(String designation);
Employee getEmployeesByDesignation(String designation);
}
