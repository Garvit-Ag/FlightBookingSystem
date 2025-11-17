package com.flightapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "booking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "flight_id")
    @NotNull(message = "Flight must not be null")
    private Flight flight;

    @NotNull
    @Column(nullable = false)
    private String bookingTime;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(String bookingTime) {
		this.bookingTime = bookingTime;
	}

	public Booking(Flight flight, String bookingTime) {
        this.flight = flight;
        this.bookingTime = bookingTime;
    }
    
    public Booking() {
    	
    }
}
