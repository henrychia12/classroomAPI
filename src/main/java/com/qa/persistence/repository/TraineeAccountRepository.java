package com.qa.persistence.repository;

public interface TraineeAccountRepository {
	
	String getAllTraineeAccounts();

	String createTraineeAccount(String account);
	
	String updateTraineeAccount(Long traineeID, String traineeFullName);

	String deleteTraineeAccount(Long traineeID);

}
