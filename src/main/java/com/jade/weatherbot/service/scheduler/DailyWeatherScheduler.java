package com.jade.weatherbot.service.scheduler;

import com.jade.weatherbot.service.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DailyWeatherScheduler {

    private final WeatherService weatherService;

    @Scheduled(cron = "*/10 * * * * *")
    public void sendDailyWeatherReport() {

        log.info("Running daily weather scheduler...");

        var weather = weatherService.getWeather("Bangkok");

        log.info("Weather today: {}", weather);

    }
}
