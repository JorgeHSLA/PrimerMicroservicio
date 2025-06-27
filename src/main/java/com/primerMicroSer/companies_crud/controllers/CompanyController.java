package com.primerMicroSer.companies_crud.controllers;


import com.primerMicroSer.companies_crud.entities.Company;
import com.primerMicroSer.companies_crud.services.CompanyService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

// en el controler es donde se exponen los co
@RestController
@AllArgsConstructor
@RequestMapping(path = "company")
@Slf4j
public class CompanyController {

    private final CompanyService companyService;


//
//    Escucha una URL dinámica con un parámetro name, por ejemplo:

    //    GET /company/Apple
    //    GET /company/Microsoft

//    Extrae el valor de {name} de la URL y lo asigna a la variable String name mediante la anotación @PathVariable.
    @Operation(summary = "get a company given a company name")
    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable String name){
        log.info("GET:/company/{}",name);
        return ResponseEntity.ok(companyService.readByName(name)); // no es necesario el buildx

    }

//    @PostMapping
//
//    Indica que este metodo responde a solicitudes POST a /company.
    @Operation(summary = "save in DB a company given a company from body")
    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company company){

        log.info("POST:/company/{}",company.getName());
        Company created = this.companyService.create(company);
        return ResponseEntity.created(
                        URI.create("/company/" + created.getName()))
                .body(created);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                                                                                                              /////
    //        el @RequestBody Company company que es lo que hace?                                                                   /////
    //                                                                                                                              /////
    //          Spring deserializa automáticamente el cuerpo JSON del request y lo convierte en una instancia de la clase Company.  /////
    //                                                                                                                              /////
    //          Por ejemplo, si el cliente envía:                                                                                   /////
    //                                                                                                                              /////
    //        {                                                                                                                     /////
    //            "name": "Apple",                                                                                                  /////
    //                "address": "California",                                                                                      /////
    //                "employees": 5000                                                                                             /////
    //                                                                                                                              /////
    //          este lo transorma en un obejeto company                                                                             /////
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Operation(summary = "update in DB a company given a company from body")
    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@RequestBody Company company,@PathVariable String name){
        log.info("PUT:/company/{}",name);
        return ResponseEntity.ok(companyService.update(company, name)); // en el ok no es necesario el build

    }



    @Operation(summary = "delete in DB a company given a company name")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable String name){
        log.info("DELETE:/company/{}",name);
        companyService.delete(name);
        return ResponseEntity.noContent().build();  // necesario el build
    }

}


