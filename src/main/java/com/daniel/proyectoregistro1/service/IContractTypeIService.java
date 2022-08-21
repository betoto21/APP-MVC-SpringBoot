package com.daniel.proyectoregistro1.service;

import com.daniel.proyectoregistro1.domain.ContractType;

import java.util.List;

public interface IContractTypeIService {

    public List<ContractType> listContractType();
    public void saveContractType(ContractType contractType);
    public void deleteContractType(ContractType contractType);
    public ContractType searchContractType(ContractType contractType);
}
