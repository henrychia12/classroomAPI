package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

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
		// TODO Auto-generated method stub
		return null;
	}

	public String updateTraineeAccount(Long traineeID, String traineeFullName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteTraineeAccount(Long traineeID) {
		// TODO Auto-generated method stub
		return null;
	}

}
