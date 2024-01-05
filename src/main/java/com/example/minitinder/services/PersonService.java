package com.example.minitinder.services;

import com.example.minitinder.models.Person;
import com.example.minitinder.models.dto.AccountCreateRequest;
import com.example.minitinder.models.dto.Response;

import java.util.List;
public interface PersonService {
    Person save(Person person);
    Person findById(Long id);

    List<Person> findAll();

    Response create(AccountCreateRequest request);
}
