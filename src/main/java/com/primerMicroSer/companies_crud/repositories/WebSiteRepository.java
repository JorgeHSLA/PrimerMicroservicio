package com.primerMicroSer.companies_crud.repositories;

import com.primerMicroSer.companies_crud.entities.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;



public interface WebSiteRepository extends JpaRepository<WebSite,Long> {
}
