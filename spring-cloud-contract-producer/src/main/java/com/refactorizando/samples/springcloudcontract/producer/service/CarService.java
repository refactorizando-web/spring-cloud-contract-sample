package com.refactorizando.samples.springcloudcontract.producer.service;

import com.refactorizando.samples.springcloudcontract.producer.domain.Car;
import com.refactorizando.samples.springcloudcontract.producer.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarService {

    private final CarRepository carRepository;

    public Car findById(Long id) {

        return carRepository.findById(id).orElseThrow();

    }

    public List<Car> findAll() {

        return carRepository.findAll();
    }
}
