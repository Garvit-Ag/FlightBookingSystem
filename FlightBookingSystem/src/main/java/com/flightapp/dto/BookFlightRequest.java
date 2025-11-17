package com.flightapp.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookFlightRequest {

    @NotNull(message = "Flight ID cannot be null")
    private Long flightId;
    
    private Long id;
    
    private String bookingTime;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public Long getFlightId() {
    	return flightId;
    }
}
