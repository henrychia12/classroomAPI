package com.qa.business.service;

public interface TraineeAccountService {
	
	String getAllTraineeAccounts();

	String createTraineeAccount(String account);
	
	String updateTraineeAccount(Long traineeID, String traineeFullName);

	String deleteTraineeAccount(Long traineeID);

}
