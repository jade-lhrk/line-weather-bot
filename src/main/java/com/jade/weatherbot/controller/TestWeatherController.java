package com.jade.weatherbot.controller;

import com.jade.weatherbot.dto.response.ApiResponse;
import com.jade.weatherbot.dto.WeatherResponse;
import com.jade.weatherbot.dto.request.WeatherRequest;
import com.jade.weatherbot.service.WeatherService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWeatherController {

    private final WeatherService weatherService;

    public TestWeatherController(WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public ApiResponse<WeatherResponse> getWeather(@Valid WeatherRequest request) {

        WeatherResponse response = weatherService.getWeather(request.getCity());
        return ApiResponse.success(response);
    }
}
