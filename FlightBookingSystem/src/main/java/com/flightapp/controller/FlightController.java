package com.flightapp.controller;

import com.flightapp.dto.AddFlightRequest;
import com.flightapp.dto.BookFlightRequest;
import com.flightapp.model.Booking;
import com.flightapp.model.Flight;
import com.flightapp.service.BookingService;
import com.flightapp.service.FlightService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flight")
public class FlightController {

    private final FlightService flightService;
    private final BookingService bookingService;

    public FlightController(FlightService flightService, BookingService bookingService) {
        this.flightService = flightService;
        this.bookingService = bookingService;
    }

    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@Valid @RequestBody AddFlightRequest req) {
        Flight flight = flightService.addFlight(req);
        return ResponseEntity.status(201).body(flight);
    }

    @PostMapping("/book")
    public ResponseEntity<Booking> bookFlight(@Valid @RequestBody BookFlightRequest req) {
        Booking booking = bookingService.bookFlight(req.getFlightId());
        return ResponseEntity.status(201).body(booking);
    }

    @GetMapping("/booking/{id}")
    public ResponseEntity<BookFlightRequest> getBooking(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBooking(id));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
        return ResponseEntity.ok("Flight deleted: " + id);
    }
}
