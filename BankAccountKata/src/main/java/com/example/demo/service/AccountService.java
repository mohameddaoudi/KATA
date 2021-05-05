package com.example.demo.service;

import com.example.demo.dao.AccountRepository;
import com.example.demo.enities.Account;
import com.example.demo.enities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TransactionService transactionService;

    public List<Account> getAll(){
        return accountRepository.findAll();
    }
    public void addAccount(Account account){
        accountRepository.save(account);
    }
    public void deleteAccount(long id){
        accountRepository.deleteById(id);
    }
    public Account getById(long id){
        return accountRepository.findById(id).get();
    }

    public void withdrawal(double amount, long id){
        accountRepository.updateAccountBalence(amount, id);

        transactionService.addTransaction(new Transaction(amount, LocalDate.now(), accountRepository.findById(id).get()));
    }

}
