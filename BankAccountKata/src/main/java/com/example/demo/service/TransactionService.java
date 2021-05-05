package com.example.demo.service;

import com.example.demo.dao.TransactionRepository;
import com.example.demo.enities.Account;
import com.example.demo.enities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public void addTransaction(Transaction transaction){
        transactionRepository.save(transaction);
    }

    public void deleteTransaction(long id){
        transactionRepository.deleteById(id);
    }

    public Transaction findById(long id){
        return transactionRepository.findById(id).get();
    }

    public List<Transaction> getTransactionsByAccountId(long id){
        return transactionRepository.findTransactionByAccount_Id(id);
    }

}
