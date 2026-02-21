package com.jade.weatherbot.dto.external;

import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherApiResponse {
    private String name;
    private MainWeather main;
    private List<Weather> weather;

    @Data
    public static class MainWeather {
        private double temp;
        private int humidity;
    }

    @Data
    public static class Weather {
        private String description;
    }

}
