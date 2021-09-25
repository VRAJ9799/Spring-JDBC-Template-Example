package com.vraj.dao;

import com.vraj.model.Employee;

import java.util.List;

public interface EmployeeDao {
        int addEmployee(Employee employee);
        int updateEmployee(Employee employee);
        int deleteEmployee(int id);
        Employee getEmployee(int id);
        List<Employee> getEmployees();

}
