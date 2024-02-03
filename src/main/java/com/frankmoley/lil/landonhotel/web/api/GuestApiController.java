package com.frankmoley.lil.landonhotel.web.api;

import com.frankmoley.lil.landonhotel.data.entity.Guest;
import com.frankmoley.lil.landonhotel.data.repository.GuestRepository;
import com.frankmoley.lil.landonhotel.web.exception.BadRequestException;
import com.frankmoley.lil.landonhotel.web.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/guests")
public class GuestApiController {
    private final GuestRepository guestRepository;

    public GuestApiController(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    @GetMapping
    public List<Guest> getAllGuests(){
        return  this.guestRepository.findAll();
    }

    @GetMapping("/{id}")
    public Guest getGuest(@PathVariable("id")long id){
        Optional<Guest> guest = this.guestRepository.findById(id);
        if (guest.isEmpty()){
            throw new NotFoundException("guest with this id not found");
        }
        return guest.get();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Guest createGuest(@RequestBody Guest guest){
        return this.guestRepository.save(guest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.RESET_CONTENT)
    public void deleteGuest(@PathVariable("id")long id){
        this.guestRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Guest updateGuest(@PathVariable("id")long id, Guest guest){
        if(id != guest.getId()) {
            throw new BadRequestException("cant find this " + id);
        } else {
           return this.guestRepository.save(guest);
        }
    }


}
