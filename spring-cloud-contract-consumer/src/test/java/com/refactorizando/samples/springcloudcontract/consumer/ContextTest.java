package com.refactorizando.samples.springcloudcontract.consumer;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ConsumerApplication.class)
public class ContextTest {

    @Test
    public void whenContextIsLoading_thenNoExceptions() {
    }
}