package com.modernjava.http;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static  java.net.http.HttpRequest.*;

import java.io.IOException;
import java.net.URI;

public class MoviesClient {

    HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(2))
                .build();
                        

    public static String ALL_MOVIES_URL = "http://127.0.0.1:8000/explore-latest-java-features/src/main/resources/movies.json";
    public static String MOVIE_BY_ID_URL = "http://127.0.0.1:8000/explore-latest-java-features/src/main/resources/movie_by_id.json";

    ObjectMapper obM = new ObjectMapper()
                        .registerModule(new JavaTimeModule())
                        .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)

    public Movie getMovieById() {
        var request = requestBuilder(MOVIE_BY_ID_URL);
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return obM.readValue(response.body(), Movie.class);
        } catch (IOException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static HttpRequest requestBuilder (String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();
    }
}
