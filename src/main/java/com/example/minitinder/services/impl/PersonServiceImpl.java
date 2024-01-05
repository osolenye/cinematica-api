package com.example.minitinder.services.impl;

import com.example.minitinder.dao.PersonRepository;
import com.example.minitinder.models.Account;
import com.example.minitinder.models.Order;
import com.example.minitinder.models.Person;
import com.example.minitinder.models.dto.AccountCreateRequest;
import com.example.minitinder.models.dto.Response;
import com.example.minitinder.services.AccountService;
import com.example.minitinder.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    private final AccountService accountService;
    @Override
    public Person save(Person person) {
        return repository.save(person);
    }

    @Override
    public Person findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("no such object with id"));
    }

    @Override
    public List<Person> findAll() {
        return repository.findAll();
    }

    @Override
    public Response create(AccountCreateRequest request) {
        try {
            Account account = accountService.create(request.getLogin());
            Person person = new Person();
            person.setAge(request.getAge());
            person.setFirstName(request.getFirstName());
            person.setSecondName(request.getLastName());
            person.setInfo(request.getInfo());
            person.setAccount(account);
            save(person);
            return new Response("Success");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
