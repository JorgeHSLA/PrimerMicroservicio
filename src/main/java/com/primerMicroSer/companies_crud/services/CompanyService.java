package com.primerMicroSer.companies_crud.services;


import com.primerMicroSer.companies_crud.entities.Company;

//metodos que se usan en el servicio de Company

// podemos ver que la interfaz tiene un crud
public interface CompanyService {

    Company readByName(String name);
    Company create(String name);
    Company update(Company company,String name);
    void delete(String name);

}
