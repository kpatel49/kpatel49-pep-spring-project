package com.example.service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public boolean usernameExists(String username){
        return accountRepository.existsByUsername(username);
    }

    public Account finfByUsername(String username){
        return accountRepository.findByUsername(username);
    }

    public boolean existsById(Integer id){
        return accountRepository.existsById(id);
    }
}
