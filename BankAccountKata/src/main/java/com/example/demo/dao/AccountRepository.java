package com.example.demo.dao;

import com.example.demo.enities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface AccountRepository extends JpaRepository<Account , Long > {
    @Transactional
    @Modifying
    @Query("update Account a set a.balance = ?1 where a.id = ?2")
    public void updateAccountBalence(double balence, long id);
}
