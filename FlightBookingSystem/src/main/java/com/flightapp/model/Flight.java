package com.flightapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "flight")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "From place cannot be blank")
    @Column(nullable = false)
    private String fromPlace;

    @NotBlank(message = "To place cannot be blank")
    @Column(nullable = false)
    private String toPlace;

    @NotBlank(message = "Take off time cannot be blank")
    @Column(nullable = false)
    private String takeOffTime;

    @NotBlank(message = "Landing time cannot be blank")
    @Column(nullable = false)
    private String landingTime;

    @NotBlank(message = "Airline name cannot be blank")
    @Column(nullable = false)
    private String airline;
    
    public Flight(String fromPlace, String toPlace, String takeOffTime, String landingTime, String airline) {
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
        this.takeOffTime = takeOffTime;
        this.landingTime = landingTime;
        this.airline = airline;
    }
    public Long getId() {
		return id;
	}
	public Flight() {
    	
    }
}
