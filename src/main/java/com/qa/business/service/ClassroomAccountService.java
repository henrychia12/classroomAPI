package com.qa.business.service;

public interface ClassroomAccountService {
	
	String getAllAccounts();

	String createAccount(String account);
	
	String updateAccount(Long id, String fullName);

	String deleteAccount(Long id);
}
