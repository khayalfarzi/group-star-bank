package com.example.starbank.service;

import com.example.starbank.controller.request.TransferBalanceRequest;
import com.example.starbank.dto.CardStatement;
import com.example.starbank.entity.Card;
import com.example.starbank.entity.Transaction;

import java.util.List;

public interface CardService {
    List<Card> findAll();
    Card save(Card card);
    Transaction sendMoney(
            TransferBalanceRequest transferBalanceRequest
    );
    CardStatement getStatement(String cardNumber);
}