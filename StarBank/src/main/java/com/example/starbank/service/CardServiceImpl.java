package com.example.starbank.service;

import com.example.starbank.controller.request.TransferBalanceRequest;
import com.example.starbank.dto.CardStatement;
import com.example.starbank.entity.Card;
import com.example.starbank.entity.Transaction;
import com.example.starbank.repository.CardRepository;
import com.example.starbank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public Card save(Card card) {
        cardRepository.save(card);
        return cardRepository.findByCardNumber(card.getCardNumber());
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findByAccountNumber(String cardNumber) {
        Card card = cardRepository.findByCardNumber(cardNumber);
        return card;
    }


    @Override
    public Transaction sendMoney(
            TransferBalanceRequest transferBalanceRequest
    ) {
        String fromCardNumber = transferBalanceRequest.getFromCardNumber();
        String toCardNumber = transferBalanceRequest.getToCardNumber();
        BigDecimal amount = transferBalanceRequest.getAmount();
        Card fromCard = cardRepository.findByCardNumber(
                fromCardNumber
        );
        Card toCard = cardRepository.findByCardNumber(toCardNumber);
        if (fromCard.getCurrentBalance().compareTo(BigDecimal.ONE) == 1
                && fromCard.getCurrentBalance().compareTo(amount) == 1
        ) {
            fromCard.setCurrentBalance(fromCard.getCurrentBalance().subtract(amount));
            cardRepository.save(fromCard);
            toCard.setCurrentBalance(toCard.getCurrentBalance().add(amount));
            cardRepository.save(toCard);
            Transaction transaction = transactionRepository.save(new Transaction(0L, fromCardNumber, amount, new Timestamp(System.currentTimeMillis())));
            return transaction;
        }
        return null;
    }

    @Override
    public CardStatement getStatement(String cardNumber) {
        Card card = cardRepository.findByCardNumber(cardNumber);
        return new CardStatement(card.getCurrentBalance(), transactionRepository.findByCardNumber(cardNumber));
    }
}