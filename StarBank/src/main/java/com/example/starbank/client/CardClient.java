package com.example.starbank.client;

import com.example.starbank.entity.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "card-api",
        url = "http://localhost:8080/api/cards")

public interface CardClient {
    @GetMapping("/")
    Root getCards();
}
