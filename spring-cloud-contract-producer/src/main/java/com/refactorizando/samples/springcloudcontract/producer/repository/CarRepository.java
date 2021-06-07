package com.refactorizando.samples.springcloudcontract.producer.repository;

import com.refactorizando.samples.springcloudcontract.producer.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByColor(String color);
}
