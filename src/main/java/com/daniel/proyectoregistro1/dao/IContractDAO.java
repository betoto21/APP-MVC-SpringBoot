package com.daniel.proyectoregistro1.dao;

import com.daniel.proyectoregistro1.domain.Contract;
import org.springframework.data.repository.CrudRepository;

public interface IContractDAO extends CrudRepository<Contract, Long> {
}
