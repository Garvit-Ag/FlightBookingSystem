package com.flightapp.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddFlightRequest {

    @NotBlank(message = "From place cannot be blank")
    private String fromPlace;

    @NotBlank(message = "To place cannot be blank")
    private String toPlace;

    @NotBlank(message = "Take off time cannot be blank")
    private String takeOffTime;

    @NotBlank(message = "Landing time cannot be blank")
    private String landingTime;

    @NotBlank(message = "Airline name cannot be blank")
    private String airline;

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public String getTakeOffTime() {
		return takeOffTime;
	}

	public void setTakeOffTime(String takeOffTime) {
		this.takeOffTime = takeOffTime;
	}

	public String getLandingTime() {
		return landingTime;
	}

	public void setLandingTime(String landingTime) {
		this.landingTime = landingTime;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}
    
}
