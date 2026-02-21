package com.jade.weatherbot.exception;

public enum ErrorCode {

    VALIDATION_ERROR("VALIDATION_001", "Invalid input"),
    WEATHER_API_ERROR("WEATHER_001", "Weather service unavailable"),
    INTERNAL_ERROR("SYSTEM_001", "Unexpected error");

    private final String code;
    private final String defaultMessage;

    ErrorCode(String code, String defaultMessage) {
        this.code = code;
        this.defaultMessage = defaultMessage;
    }

    public String getCode() {
        return code;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }
}
