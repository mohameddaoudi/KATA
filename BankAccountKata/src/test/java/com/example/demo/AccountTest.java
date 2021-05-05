package com.example.demo;

import com.example.demo.dao.AccountRepository;
import com.example.demo.enities.Account;
import com.example.demo.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;

@SpringBootTest
public class AccountTest {

    @Autowired
    AccountService accountService;

    @Test
    void accountCreationTest() {
        accountService.addAccount(new Account(LocalDate.now(), 100));
        Assert.notNull(accountService.getById(1), "Account not Null");

    }

    @Test
    void accountDrawalTest() {
        accountService.addAccount(new Account(LocalDate.now(), 100));
        Assert.notNull(accountService.getById(1), "Account not Null");

        accountService.withdrawal(50, 1);
        Assert.isTrue(accountService.getById(1).getBalance() == 50
                , "le retrait a été bien fait");
    }

    @Test
    void accountHistoryTest() {
        accountService.addAccount(new Account(LocalDate.now(), 100));
        Assert.notNull(accountService.getById(1), "Account not Null");

        accountService.withdrawal(50, 1);
        Assert.isTrue(accountService.getById(1).getBalance() == 50
                , "le retrait a été bien fait");

        accountService.withdrawal(25, 1);

        Assert.isTrue(accountService.getById(1).getTransactions().size() == 2
              , "History of account is gotten");
        System.out.println(accountService.getById(1).getTransactions().size());
    }

}
