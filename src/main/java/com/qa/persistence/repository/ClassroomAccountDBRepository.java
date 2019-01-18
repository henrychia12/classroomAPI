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
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class ClassroomAccountDBRepository implements ClassroomAccountRepository {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;

	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}

	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account newAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(newAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateAccount(Long classroomID, String trainerFullName) {
		Account accountInDB = findAccount(classroomID);
		Account newAccount = util.getObjectForJSON(trainerFullName, Account.class);
		if(accountInDB != null) {
			manager.remove(accountInDB);
			manager.persist(newAccount);
			return "{\"message\": \"has been sucessfully updated\"}";
		}
		return"{\"message\": \"details entered are invalid\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long classroomID) {
		Account accountInDB = findAccount(classroomID);
		if(accountInDB != null) {
			manager.remove(accountInDB);
			return "{\"message\": \"account sucessfully deleted\"}";
		}
		return "{\"message\": \"deletion unsuccessful\"}";
	}
	
	private Account findAccount(Long classroomID) {
		return manager.find(Account.class, classroomID);
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	}
	
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
