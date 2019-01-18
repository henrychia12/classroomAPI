package com.qa.persistence.repository;

public interface ClassroomAccountRepository {
	
	String getAllAccounts();

	String createAccount(String account);
	
	String updateAccount(Long id, String fullName);

	String deleteAccount(Long id);

}
