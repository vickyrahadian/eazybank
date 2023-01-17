package com.kode19.eazybankbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/myCards")
    public String getCards() {
        return "Here are the cards details from DB";
    }

}
