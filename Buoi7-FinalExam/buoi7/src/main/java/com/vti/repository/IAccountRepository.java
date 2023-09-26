package com.vti.repository;

import com.vti.entity.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountRepository {
    void addNewAccount(Account ac);
    List<Account> getListAccounts();

    Optional<Account> findById(int id);

    Account findAccountByUsername(String username);

    void deleteAccount(int id);

    void updateAccount(Account ac);
}
