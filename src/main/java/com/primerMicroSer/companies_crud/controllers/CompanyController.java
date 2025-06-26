package com.primerMicroSer.companies_crud.controllers;


import com.primerMicroSer.companies_crud.entities.Company;
import com.primerMicroSer.companies_crud.services.CompanyService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

// en el controler es donde se exponen los co
@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping(path = "company")
public class CompanyController {

    private final CompanyService companyService;


//
//    Escucha una URL dinámica con un parámetro name, por ejemplo:

    //    GET /company/Apple
    //    GET /company/Microsoft

//    Extrae el valor de {name} de la URL y lo asigna a la variable String name mediante la anotación @PathVariable.

    @GetMapping(path = "{name}")
    public ResponseEntity<Company> get(@PathVariable String name){
        log.info("GET: /company/"+name);
        return ResponseEntity.ok(companyService.readByName(name)); // no es necesario el buildx

    }

//    @PostMapping
//
//    Indica que este metodo responde a solicitudes POST a /company.

    @PostMapping
    public ResponseEntity<Company> post(@RequestBody Company company){

        log.info("POST: /company/"+company.getName());
        return ResponseEntity.created(URI.create(companyService.create(company).getName())).build(); // en el create es necesaio el build

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


    @PutMapping(path = "{name}")
    public ResponseEntity<Company> put(@RequestBody Company company,@PathVariable String name){
        log.info("PUT: /company/"+name);
        return ResponseEntity.ok(companyService.update(company, name)); // en el ok no es necesario el build

    }

    @DeleteMapping(path = "{name}")
    public ResponseEntity<?> delete(@PathVariable String name){
        log.info("DELETE: /company/"+name);
        companyService.delete(name);
        return ResponseEntity.noContent().build();  // necesario el build
    }

}


