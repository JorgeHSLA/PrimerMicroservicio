package com.primerMicroSer.companies_crud.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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
CREATE TABLE company
    id   BIGINT PRIMARY KEY,
    name VARCHAR(255)
);

Hibernate nos permite que las clases representen tablas
*/
@Entity
@Data
public class Company {

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    Estrategia	    Base de datos recomendada	    Ventajas	                    Desventajas                         //
//    AUTO	            Cualquiera (default)	        Portable, configurable	        Menos control                       //
//    IDENTITY	        MySQL, SQL Server, PostgreSQL	Sencillo, nativo	            No compatible con batch inserts     //
//    SEQUENCE	        Oracle, PostgreSQL	            Rendimiento en batch inserts	Requiere secuencia en DB            //
//    TABLE	            Bases sin secuencias	        Máxima portabilidad	            Lento, bloqueo de tablas            //
//    UUID	            Sistemas distribuidos	        Único global, no requiere DB	Mayor tamaño (128 bits)             //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String founder;
    private String logo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private LocalDate foundationDate;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    PERSIST	entityManager.persist()	    Guarda la entidad relacionada automáticamente                               //
//    MERGE	    entityManager.merge()	    Actualiza la entidad relacionada al actualizar la principal                 //
//    REMOVE	entityManager.remove()	    Elimina la entidad relacionada al eliminar la principal (¡Cuidado!)         //
//    REFRESH	entityManager.refresh()	    Recarga desde BD la entidad relacionada al refrescar la principal           //
//    DETACH	entityManager.detach()	    Desvincula de la sesión la entidad relacionada al desvincular la principal  //
//    ALL	    Todas las operaciones	    Propaga todas las operaciones anteriores                                    //
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @OneToMany(fetch = FetchType.LAZY , cascade = {CascadeType.MERGE, CascadeType.PERSIST , CascadeType.REMOVE})
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    private List<WebSite> webSites;
}
