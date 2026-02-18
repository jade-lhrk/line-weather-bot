package com.jade.weatherbot.controller;

import com.jade.weatherbot.client.WeatherApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWeatherController {

    private final WeatherApiClient weatherApiClient;

    public TestWeatherController(WeatherApiClient weatherApiClient){
        this.weatherApiClient = weatherApiClient;
    }

    @GetMapping("/test-weather")
    public String testWeather() {
        return weatherApiClient.getCurrentWeather();
    }
}
