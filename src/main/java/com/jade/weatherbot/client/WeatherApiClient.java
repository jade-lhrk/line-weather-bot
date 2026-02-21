package com.jade.weatherbot.client;

import com.jade.weatherbot.dto.WeatherResponse;
import com.jade.weatherbot.dto.external.OpenWeatherApiResponse;
import com.jade.weatherbot.exception.ErrorCode;
import com.jade.weatherbot.exception.WeatherApiException;
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

    public WeatherResponse getWeatherByCity(String city) {

        String apiKey = "0053d3a0189af5f83881d74f907380c1"; //รอใส่ key จริง

        String url = "http://api.openweathermap.org/data/2.5/weather"
                + "?q=" + city
                + "&appid=" + apiKey
                + "&units=metric";

        try {
            OpenWeatherApiResponse apiResponse = restTemplate.getForObject(url, OpenWeatherApiResponse.class);

            if (apiResponse == null || apiResponse.getMain() == null){
                throw new RuntimeException("Weather API error");
            }

            WeatherResponse response = new WeatherResponse();

            response.setCity(apiResponse.getName());
            response.setTemperature(apiResponse.getMain().getTemp());
            response.setHumidity(apiResponse.getMain().getHumidity());
            response.setDescription(
                    apiResponse.getWeather().get(0).getDescription()
            );

            return response;
        }catch (Exception e){
            throw new WeatherApiException(ErrorCode.WEATHER_API_ERROR);
        }


    }
}
