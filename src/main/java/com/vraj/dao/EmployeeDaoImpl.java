package com.vraj.dao;

import com.vraj.model.Employee;
import com.vraj.utils.EmployeeRowMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    @Getter
    @Setter
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int addEmployee(Employee employee) {
        int result = 0;
        try {
            result = jdbcTemplate.update("insert into employee (first_name,last_name) values (?,?)", employee.getFirst_name(), employee.getLast_name());
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return result;
        }
    }

    @Override
    public int updateEmployee(Employee employee) {
        int result=0;
        try{
            result = jdbcTemplate.update("update employee set first_name=?,last_name=? where id=?",employee.getFirst_name(),employee.getLast_name(),employee.getId());
            return result;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return result;
        }
    }

    @Override
    public int deleteEmployee(int id) {
        int result =0;
        try{
            result = jdbcTemplate.update("delete from employee where id=?",id);
            return result;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return result;
        }
    }

    @Override
    public Employee getEmployee(int id) {
        try {
            return  jdbcTemplate.queryForObject("select * from employee where id=?",new EmployeeRowMapper(),id);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees =new ArrayList<>();
        try {
            employees = jdbcTemplate.query("select * from employee",new EmployeeRowMapper());
            return employees;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return employees;
        }
    }
}
