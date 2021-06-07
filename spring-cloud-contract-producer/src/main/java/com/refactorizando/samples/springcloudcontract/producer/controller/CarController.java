package com.refactorizando.samples.springcloudcontract.producer.controller;

import com.refactorizando.samples.springcloudcontract.producer.domain.Car;
import com.refactorizando.samples.springcloudcontract.producer.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {

        var car = carService.findAll();

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {

        var car = carService.findById(id);

        return new ResponseEntity<>(car, HttpStatus.OK);

    }

}
