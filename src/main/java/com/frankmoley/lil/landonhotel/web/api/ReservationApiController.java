package com.frankmoley.lil.landonhotel.web.api;

import com.frankmoley.lil.landonhotel.data.entity.Reservation;
import com.frankmoley.lil.landonhotel.data.repository.ReservationRepository;
import com.frankmoley.lil.landonhotel.web.exception.NotFoundException;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationApiController {
    private final ReservationRepository reservationRepository;

    public ReservationApiController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAllReservations(@RequestParam(value = "date",
    required = false)String dateString) {
        if (StringUtils.isNotBlank(dateString)) {
            Date date = new Date(new java.util.Date().getTime());
            return this.reservationRepository.getAllByResDate(date);
        }
        return this.reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(@PathVariable("id")long id){
        Optional<Reservation> reservation = this.reservationRepository.findById(id);
        if(reservation.isEmpty()){
            throw new NotFoundException("not found this "+ id);
        }
        return reservation.get();
    }
}
