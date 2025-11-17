package com.flightapp.service;

import com.flightapp.dto.BookFlightRequest;
import com.flightapp.model.Booking;
import com.flightapp.model.Flight;
import com.flightapp.repository.BookingRepository;
import com.flightapp.repository.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.*;
import java.time.LocalDateTime;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;

    public BookingService(BookingRepository bookingRepository, FlightRepository flightRepository) {
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
    }

    @Transactional
    public Booking bookFlight(Long flightId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        Booking booking = new Booking(
                flight,
                LocalDateTime.now().toString()
        );

        return bookingRepository.save(booking);
    }


    public BookFlightRequest getBooking(Long bookingId) {

        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        BookFlightRequest dto = new BookFlightRequest();
        dto.setId(booking.getId());
        dto.setBookingTime(booking.getBookingTime());
        dto.setFlightId(booking.getFlight().getId());

        return dto;
    }

}
