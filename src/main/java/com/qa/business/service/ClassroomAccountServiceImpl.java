package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.ClassroomAccountRepository;
import com.qa.util.JSONUtil;

public class ClassroomAccountServiceImpl implements ClassroomAccountService {

	@Inject
	private ClassroomAccountRepository repo;
	@Inject
	private JSONUtil util;
	
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	public String createAccount(String account) {
		if((util.getObjectForJSON(account, Account.class).getTrainerFullName() == "John Snow")) {
			return "{\"message\": \"Trainer is blocked\"}";	
		}
		return repo.createAccount(account);
	}

	public String updateAccount(Long classroomID, String trainerFullName) {
		return repo.updateAccount(classroomID, trainerFullName);
	}

	public String deleteAccount(Long classroomID) {
		return repo.deleteAccount(classroomID);
	}
	
	public void setRepo(ClassroomAccountRepository repo) {
		this.repo = repo;
	}

}


