package com.jade.weatherbot.dto;

import lombok.Data;

import java.util.List;

@Data
public class AirPollutionResponse {

    private List<AirData> list;

    @Data
    public static class AirData {
        private Main main;
        private Components components;
    }

    @Data
    public static class Main {
        private double pm2_5;
    }

    @Data
    public static class Components {
        private double pm2_5;
    }
}
