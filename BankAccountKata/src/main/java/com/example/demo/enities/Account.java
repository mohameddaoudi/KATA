package com.example.demo.enities;

import lombok.Data;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Account {

    public Account(){

    }
    public Account(LocalDate creationDate, double balance){
        this.balance = balance;
        this.creationDate = creationDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    long id;

    @Column(name="CREATION_DATE")
    LocalDate creationDate;

    @Column(name="BALANCE")
    double balance ;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name="ACCOUNT_ID")
    List<Transaction> transactions;

    public void addTransaction (Transaction t){
        transactions.add(t);
    }
}
