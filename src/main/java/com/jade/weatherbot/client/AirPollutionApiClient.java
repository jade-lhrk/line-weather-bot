package com.jade.weatherbot.client;

import com.jade.weatherbot.dto.AirPollutionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class AirPollutionApiClient {
    private final RestTemplate restTemplate;

    @Value("${weather.api.key}")
    private String apiKey;

    private static final String URL =
            "http://api.openweathermap.org/data/2.5/air_pollution";

    public AirPollutionResponse getAirPollution(double lat, double lon) {

        String fullUrl = URL +
                "?lat=" + lat +
                "&lon=" + lon +
                "&appid=" + apiKey;

        return restTemplate.getForObject(fullUrl, AirPollutionResponse.class);
    }
}
