package com.example.demo.enities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Transaction {
    public Transaction(){

    }
    public Transaction(double amount , LocalDate date, Account c){
        this.amount=amount;
        this.transactionDate = date;
        this.account = c;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    long id;

    @Column(name = "AMOUNT")
    double amount ;

    @Column(name = "TRANSACTION_DATE")
    LocalDate transactionDate;

    @ManyToOne
    private Account account;
}
