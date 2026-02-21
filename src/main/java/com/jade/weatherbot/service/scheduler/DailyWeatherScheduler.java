package com.jade.weatherbot.service.scheduler;

import com.jade.weatherbot.client.LineMessagingClient;
import com.jade.weatherbot.service.AirPollutionService;
import com.jade.weatherbot.service.DailyReportFormatter;
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
    private final AirPollutionService airService;
    private final DailyReportFormatter formatter;
    private final LineMessagingClient lineClient;
    private static final String USER_ID = "Ubb745616cacb6a19c7713e35e6000abf";

    @Scheduled(cron = "*/10 * * * * *")
    public void sendDailyWeatherReport() {

        log.info("Running daily weather scheduler...");

        var weather = weatherService.getWeather("Bangkok");

        log.info("Weather today: {}", weather);

        double lat = 13.736717;
        double lon = 100.523186;

        double pm25 = airService.getPm25(lat, lon);

        String report = formatter.format(weather, pm25);

        lineClient.pushMessage(USER_ID, report);

        log.info("PM2.5 today: {}", report);

    }
}
