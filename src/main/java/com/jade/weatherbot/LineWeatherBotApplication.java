package com.jade.weatherbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LineWeatherBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(LineWeatherBotApplication.class, args);
	}

}
