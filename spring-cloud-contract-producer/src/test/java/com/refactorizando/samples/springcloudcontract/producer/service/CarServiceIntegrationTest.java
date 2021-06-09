package com.refactorizando.samples.springcloudcontract.producer.service;

import com.refactorizando.samples.springcloudcontract.producer.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql({"/schema_test.sql","/test_cars.sql"})
public class CarServiceIntegrationTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void testFindAll() {
        assertEquals(1, carRepository.findAll().size());
    }
}