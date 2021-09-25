package com.vraj;

import com.vraj.dao.EmployeeDao;
import com.vraj.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int result;
        System.out.println("Hello World!");

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        //Update
        result = employeeDao.updateEmployee(new Employee(2, "Vraj", "Shah"));
        System.out.println(result);
        //Add
        result = employeeDao.addEmployee(new Employee("Vraj", "Shah"));
        System.out.println(result);
        // Get Employee
        Employee employee = employeeDao.getEmployee(1);
        System.out.println(employee.toString());
        //Delete Employe
        result = employeeDao.deleteEmployee(2);
        // Get All Employees
        List<Employee> employees = employeeDao.getEmployees();
        for (Employee item : employees) System.out.println(item.toString());
    }
}
