package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.TraineeAccount;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class TraineeAccountDBRepository implements TraineeAccountRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	public String getAllTraineeAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<TraineeAccount> traineeAccounts =(Collection<TraineeAccount>) query.getResultList();		
		return util.getJSONForObject(traineeAccounts);
	}

	public String createTraineeAccount(String account) {
		TraineeAccount newAccount = util.getObjectForJSON(account, TraineeAccount.class);
		manager.persist(newAccount);
		return "{\"message\": \"trainee account has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateTraineeAccount(Long traineeID, String traineeFullName) {
		TraineeAccount accountInDB =findAccount(traineeID);
		TraineeAccount newAccount = util.getObjectForJSON(traineeFullName, TraineeAccount.class);
		if(accountInDB != null) {
			manager.remove(accountInDB);
			manager.persist(newAccount);
			return "{\"message\": \"has been sucessfully updated\"}";
		}
		return null;
	}
	
	@Transactional(REQUIRED)
	public String deleteTraineeAccount(Long traineeID) {
		TraineeAccount accountInDB = findAccount(traineeID);
		if(accountInDB != null) {
			manager.remove(accountInDB);
			return "{\"message\": \"account sucessfully deleted\"}";
		}
		return "{\"message\": \"deletion unsuccessful\"}";
	}
	
	private TraineeAccount findAccount(Long traineeID) {
		return manager.find(TraineeAccount.class, traineeID);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
