package com.example.demo.controllers;

import com.example.demo.enities.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/account/")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("all")
    public List<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("one")
    public Account getById(@PathVariable long id){
        return accountService.getById(id);
    }

    // en peux ajouter

}
