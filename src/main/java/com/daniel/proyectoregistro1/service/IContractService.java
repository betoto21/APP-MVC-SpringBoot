package com.daniel.proyectoregistro1.service;

import com.daniel.proyectoregistro1.domain.Contract;

import java.util.List;

public interface IContractService {

    public List<Contract> listContracts();
    public void saveContract(Contract contract);
    public void deleteContract(Contract contract);
    public Contract searchContract(Contract contract);
}
