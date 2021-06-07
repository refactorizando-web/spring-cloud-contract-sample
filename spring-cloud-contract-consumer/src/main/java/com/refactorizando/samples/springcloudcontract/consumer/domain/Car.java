package com.refactorizando.samples.springcloudcontract.consumer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Car {

    private Long id;

    private String color;

    private String model;

    private String brand;
}
