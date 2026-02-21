package com.jade.weatherbot.service;

import com.jade.weatherbot.client.AirPollutionApiClient;
import com.jade.weatherbot.dto.AirPollutionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirPollutionService {
    private final AirPollutionApiClient apiClient;

    public double getPm25(double lat, double lon) {

        AirPollutionResponse response = apiClient.getAirPollution(lat, lon);

        return response.getList()
                .get(0)
                .getComponents()
                .getPm2_5();
    }
}
