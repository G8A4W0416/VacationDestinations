package dmacc.beans;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String destination;
	private int tripCost;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tripStart;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate tripEnd;
	
	public Trip() {
		super();
	}
	
	public Trip(String destination, int tripCost, LocalDate tripStart, LocalDate tripEnd) {
		this.destination = destination;
		this.tripCost = tripCost;
		this.tripStart = tripStart;
		this.tripEnd = tripEnd;
	}

	public Trip(long id, String destination, int tripCost, LocalDate tripStart, LocalDate tripEnd) {
		this.id = id;
		this.destination = destination;
		this.tripCost = tripCost;
		this.tripStart = tripStart;
		this.tripEnd = tripEnd;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTripCost() {
		return tripCost;
	}

	public void setTripCost(int tripCost) {
		this.tripCost = tripCost;
	}

	public LocalDate getTripStart() {
		return tripStart;
	}

	public void setTripStart(LocalDate tripStart) {
		this.tripStart = tripStart;
	}

	public LocalDate getTripEnd() {
		return tripEnd;
	}

	public void setTripEnd(LocalDate tripEnd) {
		this.tripEnd = tripEnd;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", destination=" + destination + ", tripCost=" + tripCost + ", tripStart=" + tripStart
				+ ", tripEnd=" + tripEnd + "]";
	}
	
}
