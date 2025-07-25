package com.primerMicroSer.companies_crud.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;


@Entity
@Data
public class WebSite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //va a ser la columna llamada category
    @Column(columnDefinition = "category")
    @Enumerated(value = EnumType.STRING)
    private Category category;
    private String description;
}
//Controla cómo JPA (Java Persistence API) mapea un enum Java a la base de datos.
//ejemplo:
//    Valor Java	        Almacenado en DB como
//    Category.TECHNOLOGY	"TECHNOLOGY"
//    Category.HEALTHCARE	"HEALTHCARE"
//    Category.EDUCATION	"EDUCATION"
