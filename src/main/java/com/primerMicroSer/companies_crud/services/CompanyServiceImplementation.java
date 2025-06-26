package com.primerMicroSer.companies_crud.services;

import com.primerMicroSer.companies_crud.entities.Category;
import com.primerMicroSer.companies_crud.entities.Company;
import com.primerMicroSer.companies_crud.repositories.CompanyRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Objects;


@Service
@Transactional
@Slf4j
@AllArgsConstructor //todos los contructores estan por defecto
public class CompanyServiceImplementation implements CompanyService {


    // @Autowired ya no es necesario, solo se necesita en tests, se incluye en AllargsConstructor
    private final CompanyRepository companyRepository;


    @Override
    public Company create(Company company) {

        company.getWebSites().forEach(webSite->
                {
                    if(Objects.isNull(webSite.getCategory())){
                        webSite.setCategory(Category.NONE);
                    }
                }
        );
        return this.companyRepository.save(company); //se guarda y se retorn aal mismo tiempo
    }
    @Override
    public Company readByName(String name) {

        return companyRepository.findByName(name).orElseThrow(()-> new NoSuchElementException("error finding a company by a name")); //orElseTrow para lanzar una excepcion
    }
    @Override
    public Company update(Company company, String name) {

        return null;
    }

    @Override
    public void delete(String name) {

    }
}
