package com.example.starbank.controller.api;

import com.example.starbank.controller.request.CardStatementRequest;
import com.example.starbank.controller.request.TransferBalanceRequest;
import com.example.starbank.controller.response.Response;
import com.example.starbank.entity.Card;
import com.example.starbank.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/card")
public class CardController {
    @Autowired
    private CardService cardService;
    @RequestMapping("/create")
    public List<Card> create(@RequestBody Card card) {
        cardService.save(card);
        return cardService.findAll();
    }

    @RequestMapping("/all")
    public List<Card> all() {
        return cardService.findAll();
    }

    @RequestMapping("/sendmoney")
    public Response sendMoney(
            @RequestBody TransferBalanceRequest transferBalanceRequest
    ) {

        return Response.ok().setPayload(
                cardService.sendMoney(
                        transferBalanceRequest
                )
        );
    }
    @RequestMapping("/statement")
    public Response getStatement(
            @RequestBody CardStatementRequest cardStatementRequest

    ){
        return Response.ok().setPayload(
                cardService.getStatement(cardStatementRequest.getCardNumber())
        );

    }

}