package com.refactorizando.samples.springcloudcontract.producer.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Car {

    @Id
    private Long id;

    private String color;

    private String model;

    private String brand;
}
