package com.frankmoley.lil.landonhotel.data.repository;

import com.frankmoley.lil.landonhotel.data.entity.Guest;
import com.frankmoley.lil.landonhotel.data.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GuestRepository extends JpaRepository<Guest, Long > {
    Optional<Guest> findByCountryIgnoreCase(String roomNumber);
}
