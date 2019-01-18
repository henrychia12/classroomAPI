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
		return service.getAllAccounts();
	}
	

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) {
		return service.createAccount(account);
	}

	@Path("/deleteAccount/{classroomID}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("classroomID") Long classroomID) {

		return service.deleteAccount(classroomID);
	}
	
	@Path("/updateAccount/{classroomID}")
	@POST
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("classroomID") Long classroomID, String trainerFullName) {
		return service.updateAccount(classroomID,trainerFullName);
	}

	public void setService(ClassroomAccountService service) {
		this.service = service;
	}

}
