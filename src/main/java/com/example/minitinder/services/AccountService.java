package com.example.minitinder.services;

import com.example.minitinder.models.Account;

public interface AccountService {
    Account save(Account account);
    Account findById(Long id);
    Account create(String login);
}
