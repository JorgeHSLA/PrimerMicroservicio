package com.primerMicroSer.companies_crud.repositories;

import com.primerMicroSer.companies_crud.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//se creo basandinis en la base de datos, ya que aca es donde se comunica con esta
public interface CompanyRepository extends JpaRepository<Company, Long> {


    // senusa el nombre porque este tambien se considero un index en el esquema que tenemos para la base de datos
    Optional<Company> findByName(String name);
}
