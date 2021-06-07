package com.refactorizando.samples.springcloudcontract.consumer.controller;

import com.refactorizando.samples.springcloudcontract.consumer.domain.Car;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class CarController {

    private WebClient webClient;

    @PostConstruct
    public void setUpWebClient() {
        var httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 2_000)
                .doOnConnected(connection ->
                        connection.addHandlerLast(new ReadTimeoutHandler(2))
                                .addHandlerLast(new WriteTimeoutHandler(2)));

        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8090")
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars() {

        var cars = webClient.get().uri("/cars").accept(MediaType.APPLICATION_JSON)
                .retrieve().bodyToMono(Car[].class).block();

        return new ResponseEntity<>(Arrays.stream(cars).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {


        var car = webClient.get().uri("/cars").retrieve().bodyToMono(Car.class).block();

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

}
