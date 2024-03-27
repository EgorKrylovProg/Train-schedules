package com.shedules.apischedules.Schedules;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
public class Controller {
    final String apiKey = "36f4fce2-873f-4950-b7fe-41bc500cd0d9";

    @GetMapping(value = "/infoSchedules/{type}/")
    public String getRequestSchedule(@PathVariable String type, HttpServletRequest request) {
        StringBuilder uriStr = new StringBuilder("https://api.rasp.yandex.net/v3.0/")
                .append(type)
                .append("/?")
                .append("apikey=")
                .append(apiKey);
        Map<String, String[]> params = request.getParameterMap();

        for (Map.Entry<String, String[]> entry : params.entrySet()) {
            uriStr.append("&").append(entry.getKey()).append("=").append(String.join(",", entry.getValue()));
        }

        try {
            return ConnectionToYandexApi.getSchedule(uriStr.toString().replace(" ", ""));
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}