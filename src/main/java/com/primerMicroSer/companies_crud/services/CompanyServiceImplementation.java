package com.primerMicroSer.companies_crud.services;

import com.primerMicroSer.companies_crud.entities.Company;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class CompanyServiceImplementation implements CompanyService {


    @Override
    public Company readByName(String name) {
        return null;
    }

    @Override
    public Company create(String name) {
        return null;
    }

    @Override
    public Company update(Company company, String name) {
        return null;
    }

    @Override
    public void delete(String name) {

    }
}
