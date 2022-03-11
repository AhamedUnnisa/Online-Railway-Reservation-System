package com.railwayBook.Train_Booking_Service.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "BookedTicket")
public class BookTrain {
	
	@Id
	private String train_id;
	@Field
	private String source;
	@Field
	private String destination;
	@Field
	private String seats;
	
	public BookTrain(){
		
	}

	public BookTrain(String train_id, String source, String destination, String seats) {
		super();
		this.train_id = train_id;
		this.source = source;
		this.destination = destination;
		this.seats = seats;
	}

	public String getTrain_id() {
		return train_id;
	}

	public void setTrain_id(String train_id) {
		this.train_id = train_id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}
	
}
