package com.jade.weatherbot.exception;

import com.jade.weatherbot.dto.error.FieldErrorResponse;
import com.jade.weatherbot.dto.response.ApiResponse;
import com.jade.weatherbot.dto.error.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WeatherApiException.class)
    public ResponseEntity<ApiResponse<Void>> handleWeatherError(WeatherApiException ex, HttpServletRequest request) {

        ApiResponse<Void> response = ApiResponse.error(
                new ErrorResponse(ex.getErrorCode().getCode(), ex.getMessage(), null)
        );

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Void>> handleValidationError(
            MethodArgumentNotValidException ex,
            HttpServletRequest request
    ) {

        List<FieldErrorResponse> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> new FieldErrorResponse(
                        err.getField(),
                        err.getDefaultMessage()
                ))
                .toList();

        ErrorResponse response = new ErrorResponse(ErrorCode.VALIDATION_ERROR.getCode(), ErrorCode.VALIDATION_ERROR.getDefaultMessage(), fieldErrors);

        return ResponseEntity.badRequest().body(ApiResponse.error(response));
    }
}
