package com.frankmoley.lil.landonhotel.data.repository;

import com.frankmoley.lil.landonhotel.data.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> getAllByResDate(Date date);
}
