package com.daniel.proyectoregistro1.service;

import com.daniel.proyectoregistro1.dao.IEmployeeDAO;
import com.daniel.proyectoregistro1.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements IEmployeeService{

    @Autowired
   private IEmployeeDAO employeeDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> listEmployees() {
        return (List<Employee>) employeeDAO.findAll();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteById(employee.getId_employee());
    }

    @Override
    @Transactional(readOnly = true)
    public Employee searchEmployee(Employee employee) {
        return employeeDAO.findById(employee.getId_employee()).orElse(null);
    }
}
