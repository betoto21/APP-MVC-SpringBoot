package com.daniel.proyectoregistro1.dao;

import com.daniel.proyectoregistro1.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface IEmployeeDAO extends CrudRepository<Employee, Long> {

}
