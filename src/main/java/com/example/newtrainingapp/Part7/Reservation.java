package com.example.newtrainingapp.Part7;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Reservation {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String hotelName;
    private int numberOfPeople;
    private Standard standard;
    private float price;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(long l, String res1, String hotel1, int i, Standard normal, float v, LocalDate now, LocalDate plusDays) {
    }
}
