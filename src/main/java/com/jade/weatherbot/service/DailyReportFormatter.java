package com.jade.weatherbot.service;

import com.jade.weatherbot.dto.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class DailyReportFormatter {
    public String format(WeatherResponse weather, double pm25) {

        String pmLevel = classifyPm25(pm25);

        return """
                Bangkok วันนี้

                🌤 อากาศ: %s
                🌡 อุณหภูมิ: %.1f°C
                💧 ความชื้น: %d%%
                😷 PM2.5: %.1f µg/m³ (%s)

                ดูแลสุขภาพด้วยนะครับ 🙂
                """.formatted(
                weather.getDescription(),
                weather.getTemperature(),
                weather.getHumidity(),
                pm25,
                pmLevel
        );
    }

    private String classifyPm25(double pm25) {

        if (pm25 <= 25) return "ดี";
        if (pm25 <= 50) return "ปานกลาง";
        if (pm25 <= 100) return "เริ่มมีผลต่อสุขภาพ";
        if (pm25 <= 200) return "ไม่ดีต่อสุขภาพ";
        return "อันตราย";
    }
}
