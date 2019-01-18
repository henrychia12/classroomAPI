package com.qa.persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TraineeAccount {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long traineeID;
	private String traineeFullName;
	
	public TraineeAccount() {
		
	}
	
	public TraineeAccount(String traineeFullName) {
		this.traineeFullName = traineeFullName;
	}

	public Long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(Long traineeID) {
		this.traineeID = traineeID;
	}

	public String getTraineeFullName() {
		return traineeFullName;
	}

	public void setTraineeFullName(String traineeFullName) {
		this.traineeFullName = traineeFullName;
	}
	
	@Override
	public String toString() {
		return "traineeID: " + traineeID + ", Trainee: " + traineeFullName;
	}

	
}
