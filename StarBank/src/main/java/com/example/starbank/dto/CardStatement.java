package com.example.starbank.dto;

import com.example.starbank.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardStatement {
    BigDecimal currentBalance;
    List<Transaction> transactionHistory;
}