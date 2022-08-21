package com.daniel.proyectoregistro1.service;

import com.daniel.proyectoregistro1.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    public List<Employee> listEmployees();
    public void saveEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
    public Employee searchEmployee(Employee employee);
}
