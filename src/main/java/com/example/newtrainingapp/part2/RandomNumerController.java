package com.example.newtrainingapp.part2;


import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class RandomNumerController {

    private final RandomBooleanProvider randomBooleanProvider;


    @GetMapping("/api/random-boolean")
    public Boolean showFirstNumber(){
        return randomBooleanProvider.getValue();
    }


}
