package com.example.newtrainingapp.Part7;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

    public interface ReservationRepository extends JpaRepository<Reservation, Long> {
        List<Reservation> findAllByName(String name);
        List<Reservation> findAllByStandardAndPrice(Standard standard, float price);
        List<Reservation> findAllByEndDateGreaterThanEqualAndStartDateLessThanEqual(LocalDate date1, LocalDate date2);
    }
