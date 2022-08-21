package com.daniel.proyectoregistro1.domain;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "contract")
public class Contract implements Serializable{

    @Autowired
    private static final long serialVersionUID = 1l;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_contract;
    private String name_contract;
    private Long id_employee;
    private Long id_contracttype;
    private String date_from;
    private String date_to;
    private String date_created;
}
