package com.caseStudy.RRS;

import org.springframework.data.annotation.Id;


import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Train")
public class Admin {
	
	
	public Admin(String trainid, String trainName, String startStation, String endStation) {
		super();
		this.trainid = trainid;
		this.trainName = trainName;
		this.startStation = startStation;
		this.endStation = endStation;
	}



	@Id
	private String trainid;
	private String trainName;
	private String startStation;
	private String endStation;
	public String getTrainid() {
		return trainid;
	}
	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getStartStation() {
		return startStation;
	}
	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}
	public String getEndStation() {
		return endStation;
	}
	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}
	@Override
	public String toString() {
		return "Train [trainid=" + trainid + ", trainName=" + trainName + ", startStation=" + startStation
				+ ", endStation=" + endStation + "]";
	}
	
	
}
