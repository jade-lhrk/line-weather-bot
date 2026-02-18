package com.jade.weatherbot.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherApiClient {

    private final RestTemplate restTemplate;

    @Autowired
    public WeatherApiClient(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public String getCurrentWeather() {

        String apiKey = "0053d3a0189af5f83881d74f907380c1"; //รอใส่ key จริง
        String city = "Bangkok";

        String url = "http://api.openweathermap.org/data/2.5/weather"
                + "?q=" + city
                + "&appid=" + apiKey
                + "&units=metric";

        return restTemplate.getForObject(url, String.class);
    }
}
