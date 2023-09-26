package com.vti.service;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;
import java.util.List;
import java.util.Optional;

public class AccountService implements IAccountService{
    private AccountRepository accountRepository;

    public AccountService() {
        accountRepository = new AccountRepository();
    }

    @Override
    public void addNewAccount(Account ac) {
        accountRepository.addNewAccount(ac);
    }

    @Override
    public List<Account> getListAccounts() {
        return accountRepository.getListAccounts();
    }

    @Override
    public void deleteAccount(int id) {

        accountRepository.deleteAccount(id);
    }

    @Override
    public void updateAccount(Account ac) {
        accountRepository.updateAccount(ac);
    }

}
