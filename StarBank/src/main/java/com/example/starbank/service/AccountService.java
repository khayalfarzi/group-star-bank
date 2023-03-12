package com.example.starbank.service;

import com.example.starbank.controller.request.TransferBalanceRequest;
import com.example.starbank.dto.AccountStatement;
import com.example.starbank.entity.Account;
import com.example.starbank.entity.Transaction;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account save(Account account);
    Transaction sendMoney(
            TransferBalanceRequest transferBalanceRequest
    );
    AccountStatement getStatement(String accountNumber);
}