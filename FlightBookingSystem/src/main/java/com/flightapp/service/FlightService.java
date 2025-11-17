package com.flightapp.service;

import com.flightapp.dto.AddFlightRequest;
import com.flightapp.model.Flight;
import com.flightapp.repository.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Transactional
    public Flight addFlight(AddFlightRequest req) {
        Flight f = new Flight(
                req.getFromPlace(),
                req.getToPlace(),
                req.getTakeOffTime(),
                req.getLandingTime(),
                req.getAirline()
        );
        return flightRepository.save(f);
    }

    @Transactional
    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }
}
