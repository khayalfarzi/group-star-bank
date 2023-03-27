package com.example.starbank.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "card")
public class Card {

    private  long id;
    private  String card_No;
    private  BigDecimal balance;

    private  int cvv;
    private  Date expireData;
    private  int pin;
    private  LocalDateTime createdAt;
    private  LocalDateTime updatedAt;


}