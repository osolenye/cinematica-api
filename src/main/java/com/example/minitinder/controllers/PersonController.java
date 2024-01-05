package com.example.minitinder.controllers;

import com.example.minitinder.models.Person;
import com.example.minitinder.models.dto.AccountCreateRequest;
import com.example.minitinder.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@AllArgsConstructor
public class PersonController {
    private final PersonService personService;

//    @PostMapping("/save")
//    Person save(@RequestBody Person person) {
//        return personService.save(person);
//    }
//
//    @GetMapping("/find/by/id/{id}")
//    Person findById(@PathVariable Long id) {
//        return personService.findById(id);
//    }
//
//    @GetMapping("/find/all")
//    List<Person> findAll() {
//        return personService.findAll();
//    }

    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody AccountCreateRequest request) {
        try{
            return new ResponseEntity<>(personService.create(request), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
