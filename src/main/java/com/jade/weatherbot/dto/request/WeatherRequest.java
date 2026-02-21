package com.jade.weatherbot.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class WeatherRequest {

    @NotBlank(message = "City is required")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "City must contain only letters")
    private String city;
}
