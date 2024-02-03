package com.frankmoley.lil.landonhotel.web.api;

import com.frankmoley.lil.landonhotel.data.entity.Reservation;
import com.frankmoley.lil.landonhotel.data.repository.ReservationRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
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
}
