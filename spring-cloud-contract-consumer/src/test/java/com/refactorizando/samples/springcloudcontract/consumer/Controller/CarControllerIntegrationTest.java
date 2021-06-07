package com.refactorizando.samples.springcloudcontract.consumer.Controller;

import com.refactorizando.samples.springcloudcontract.consumer.controller.CarController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.refactorizando.sample:spring-cloud-contract-producer:+:stubs:8080")
public class CarControllerIntegrationTest {

    @Autowired
    private CarController carController;

    @Test
    void testContractToCarsProducer() {

        var result = carController.getCars().getBody();

        assertTrue(1 == result.size());

        var car = result.get(0);

        assertTrue(car.getBrand().equalsIgnoreCase("Ford"));
        assertTrue(car.getId().equals(1L));
        assertTrue(car.getColor().equalsIgnoreCase("Yellow"));
        assertTrue(car.getModel().equalsIgnoreCase("Mustang"));

    }

    @Test
    void testContractToCarByIdProducer() {

        var result = carController.getCarById(1L).getBody();

        assertTrue(1 == result.getId());

        assertTrue(result.getBrand().equalsIgnoreCase("Ford"));
        assertTrue(result.getId().equals(1L));
        assertTrue(result.getColor().equalsIgnoreCase("Yellow"));
        assertTrue(result.getModel().equalsIgnoreCase("Mustang"));

    }

}
