package com.example.demo.controllers;

import com.example.demo.enities.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/transaction/")
public class AccountTransactions {

    @Autowired
    TransactionService transactionService;

    @GetMapping("byacount")
    public List<Transaction> getTransactions(@PathVariable long accountId){
        return transactionService.getTransactionsByAccountId(accountId);
    }

}
