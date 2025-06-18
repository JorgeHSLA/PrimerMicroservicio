package com.primerMicroSer.companies_crud.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

/*
mapeo de bases de datos
    traducir estructuras de objetos en tu código a tablas de una base de datos, y viceversa.

ejemplo sencillo:
tenemos esta clase java
public class Company {
    private Long id;       // -> Columna "id" (PK)
    private String name;   // -> Columna "name"
}
por ende en la base de datos se debe expresar como
CREATE TABLE company (
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255)
);

Hibernate nos permite que las clases representen tablas
*/
@Entity
@Data
public class Company {
    private Long id;
    private String name;
    private String founder;
    private String logo;
    private LocalDate foundationDate;
}
