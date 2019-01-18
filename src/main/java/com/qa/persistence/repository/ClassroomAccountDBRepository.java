package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
		// TODO Auto-generated method stub
		return null;
	}

	public String createAccount(String account) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateAccount(Long id, String fullName) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteAccount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}
	
	
	

}
