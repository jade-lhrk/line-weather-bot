package com.jade.weatherbot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class LineWebhookController {

    @PostMapping
    public ResponseEntity<String> handleWebhook(@RequestBody String payload) {

        System.out.println("===== LINE WEBHOOK RECEIVED =====");
        System.out.println(payload);

        return ResponseEntity.ok("OK");
    }
}
