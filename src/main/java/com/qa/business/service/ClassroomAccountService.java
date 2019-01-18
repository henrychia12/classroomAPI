package com.qa.business.service;

public interface ClassroomAccountService {
	
	String getAllAccounts();

	String createAccount(String account);
	
	String updateAccount(Long classroomID, String trainerFullName);

	String deleteAccount(Long classroomID);
}
