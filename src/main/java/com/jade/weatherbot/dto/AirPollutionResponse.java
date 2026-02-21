package com.jade.weatherbot.dto;

import lombok.Data;

import java.util.List;

@Data
public class AirPollutionResponse {

    private List<AirData> list;

    @Data
    public static class AirData {
        private Main main;
    }

    @Data
    public static class Main {
        private double pm2_5;
    }
}
