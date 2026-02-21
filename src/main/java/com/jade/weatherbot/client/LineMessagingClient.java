package com.jade.weatherbot.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class LineMessagingClient {

    private final RestTemplate restTemplate;

    @Value("${line.bot.token}")
    private String channelToken;

    private static final String PUSH_API =
            "https://api.line.me/v2/bot/message/push";

    public void pushMessage(String userId, String message) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(channelToken);

        Map<String, Object> body = Map.of(
                "to", userId,
                "messages", new Object[]{
                        Map.of(
                                "type", "text",
                                "text", message
                        )
                }
        );

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        restTemplate.postForEntity(PUSH_API, request, String.class);
    }
}
