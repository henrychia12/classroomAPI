package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long classroomID;
	private String trainerFullName;

	public Account() {

	}

	public Account(String trainerFullName) {
		this.trainerFullName = trainerFullName;
	}

	public Long getId() {
		return classroomID;
	}

	public void setId(Long id) {
		this.classroomID = id;
	}

	public String getTrainerFullName() {
		return trainerFullName;
	}

	public void setTrainerFullName(String trainerFullName) {
		this.trainerFullName = trainerFullName;
	}

	@Override
	public String toString() {
		return "classroomID: " + classroomID + ", Trainer: " + trainerFullName;
	}

}
