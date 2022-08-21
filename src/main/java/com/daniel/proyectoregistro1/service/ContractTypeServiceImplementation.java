package com.daniel.proyectoregistro1.service;

import com.daniel.proyectoregistro1.dao.IContractTypeDAO;
import com.daniel.proyectoregistro1.domain.ContractType;
import com.daniel.proyectoregistro1.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ContractTypeServiceImplementation implements IContractTypeIService{
    @Autowired
    private IContractTypeDAO contractTypeDAO;

    @Override
    @Transactional(readOnly = true)
    public List<ContractType> listContractType() {
        return (List<ContractType>) contractTypeDAO.findAll();
    }

    @Override
    @Transactional
    public void saveContractType(ContractType contractType) {
        contractTypeDAO.save(contractType);
    }

    @Override
    @Transactional
    public void deleteContractType(ContractType contractType) {
        contractTypeDAO.deleteById(contractType.getId_contracttype());
    }

    @Override
    @Transactional(readOnly = true)
    public ContractType searchContractType(ContractType contractType) {
        return contractTypeDAO.findById(contractType.getId_contracttype()).orElse(null);
    }
}
