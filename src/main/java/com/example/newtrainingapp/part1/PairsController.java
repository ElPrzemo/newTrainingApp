package com.example.newtrainingapp.part1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/pairs")
@RequiredArgsConstructor
public class PairsController {

    @GetMapping("/{name}")
    public NamedPairs getNamedEmptyPairs(@PathVariable final String name) {
        return NamedPairs.builder()
                .simpleName(name)
                .pairs(Map.of())
                .build();
    }
}