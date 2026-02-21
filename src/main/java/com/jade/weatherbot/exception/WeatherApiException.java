package com.jade.weatherbot.exception;

public class WeatherApiException extends RuntimeException{

    private final ErrorCode errorCode;

    public WeatherApiException(ErrorCode errorCode) {
        super(errorCode.getDefaultMessage());
        this.errorCode = errorCode;
    }

    public WeatherApiException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
