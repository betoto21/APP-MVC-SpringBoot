package com.daniel.proyectoregistro1.service;

import com.daniel.proyectoregistro1.dao.IContractDAO;
import com.daniel.proyectoregistro1.domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class ContractServiceImplementation implements IContractService{

    @Autowired
    private IContractDAO contractDAO;

    @Override
    @Transactional(readOnly = true)
    public List<Contract> listContracts() {
        return (List<Contract>) contractDAO.findAll();
    }

    @Override
    @Transactional
    public void saveContract(Contract contract) {
        contractDAO.save(contract);
    }

    @Override
    @Transactional
    public void deleteContract(Contract contract) {
        contractDAO.deleteById(contract.getId_contract());
    }

    @Override
    @Transactional(readOnly = true)
    public Contract searchContract(Contract contract) {
        return contractDAO.findById(contract.getId_contract()).orElse(null);
    }
}
