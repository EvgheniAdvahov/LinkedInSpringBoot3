package com.frankmoley.lil.landonhotel.web.controller;

import com.frankmoley.lil.landonhotel.service.RoomReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    private final RoomReservationService roomReservationService;

    public ReservationController(RoomReservationService roomReservationService) {
        this.roomReservationService = roomReservationService;
    }
    @GetMapping
    public String getReservation(Model model) {
        model.addAttribute("reservations", this.roomReservationService.getRoomReservationsForDate("2023-08-28"));
        return "reservation-list";
    }
}
