package com.qa.business.service;

import javax.inject.Inject;

import com.qa.persistence.domain.TraineeAccount;
import com.qa.persistence.repository.TraineeAccountRepository;
import com.qa.util.JSONUtil;

public class TraineeAccountServiceImpl implements TraineeAccountService {
	
	@Inject
	private TraineeAccountRepository repo;
	@Inject
	private JSONUtil util;

	public String getAllTraineeAccounts() {
		return repo.getAllTraineeAccounts();
	}

	public String createTraineeAccount(String account) {
		if((util.getObjectForJSON(account, TraineeAccount.class).getTraineeFullName() == "Justin Bieber")) {
			return "{\"message\": \"Trainee is blocked\"}";	
		}
		return repo.createTraineeAccount(account);
	}

	public String updateTraineeAccount(Long traineeID, String traineeFullName) {
		return repo.updateTraineeAccount(traineeID, traineeFullName);
	}

	public String deleteTraineeAccount(Long traineeID) {
		return repo.deleteTraineeAccount(traineeID);
	}
	
	public void setRepo(TraineeAccountRepository repo) {
		this.repo = repo;
	}

}
