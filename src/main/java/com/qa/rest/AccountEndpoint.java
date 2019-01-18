package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.qa.business.service.ClassroomAccountService;

@Path("/account")
public class AccountEndpoint {
	
	@Inject
	private ClassroomAccountService service;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
//		http://localhost:8080/AccountProject/api/account/getAllAccounts
		return service.getAllAccounts();
	}

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) {
//		http://localhost:8080/AccountProject/api/account/createAccount
		return service.createAccount(account);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
//		http://localhost:8080/AccountProject/api/account/deleteAccount/1
		return service.deleteAccount(id);
	}
	
	@Path("/updateAccount/{id}")
	@POST
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String account) {
//		http://localhost:8080/AccountProject/api/account/updateAccount/3
		return service.updateAccount(id,account);
	}

	public void setService(ClassroomAccountService service) {
		this.service = service;
	}

//  Post a new Account / Update	
//	{
//		firstName: Jane,
//		lastName: Do,
//		accountNumbe: 2
//	}
	
}