package com.jade.weatherbot.service;

import com.jade.weatherbot.client.WeatherApiClient;
import com.jade.weatherbot.dto.WeatherResponse;
import com.jade.weatherbot.dto.external.OpenWeatherApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private final WeatherApiClient weatherApiClient;

    @Autowired
    public WeatherService(WeatherApiClient weatherApiClient){
        this.weatherApiClient = weatherApiClient;
    }

    public WeatherResponse getWeather(String city){
        return weatherApiClient.getWeatherByCity(city);
    }
}
