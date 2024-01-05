package com.example.minitinder.services.impl;

import com.example.minitinder.dao.AccountRepository;
import com.example.minitinder.models.Account;
import com.example.minitinder.services.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository repository;
    @Override
    public Account save(Account account) {
        return repository.save(account);
    }

    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public Account create(String login) {
        Account account = new Account();
        account.setLogin(login);
        int passwordLength = 4;
        account.setPassword(generatePassword(4));
        account = save(account);
        return account;
    }

    public static String generatePassword(int length) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(random.nextInt(10)); // Appends a random digit (0-9)
        }

        return password.toString();
    }
}
