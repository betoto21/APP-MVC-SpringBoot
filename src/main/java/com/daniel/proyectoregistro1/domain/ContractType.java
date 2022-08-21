package com.daniel.proyectoregistro1.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "contracttype")
public class ContractType implements Serializable {

    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contracttype;
    private String name_contract;
    private String date_created;
}
