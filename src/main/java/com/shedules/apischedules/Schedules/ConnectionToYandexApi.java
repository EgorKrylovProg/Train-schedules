package com.shedules.apischedules.Schedules;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionToYandexApi {
    static final HttpClient httpclient = HttpClient.newHttpClient();

    public static String getSchedule(String uri) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .build();
        return httpclient.send(getRequest, HttpResponse.BodyHandlers.ofString()).body();
    }

//    "https://api.rasp.yandex.net/v3.0/search/?apikey= &format=json&from=c10743&to=c213&lang=ru_RU&page=1&date=2024-03-25&limit=1"
}
