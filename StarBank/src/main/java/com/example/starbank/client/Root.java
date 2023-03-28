package com.example.starbank.client;

import com.example.starbank.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Root {

    private List<Card> CardInfo = new ArrayList<>();

}
