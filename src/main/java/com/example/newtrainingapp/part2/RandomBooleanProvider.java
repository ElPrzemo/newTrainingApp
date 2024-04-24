package com.example.newtrainingapp.part2;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Random;

@RequestScope
@Component
public class RandomBooleanProvider {
    private final boolean value = new Random().nextBoolean();

    public boolean getValue() {
        return value;
    }
}