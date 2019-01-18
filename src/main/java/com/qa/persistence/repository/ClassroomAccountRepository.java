package com.qa.persistence.repository;

public interface ClassroomAccountRepository {
	
	String getAllAccounts();

	String createAccount(String account);
	
	String updateAccount(Long classroomID, String trainerFullName);

	String deleteAccount(Long classroomID);

}
