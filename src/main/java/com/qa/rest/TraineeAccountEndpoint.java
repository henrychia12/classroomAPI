package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.ClassroomAccountService;
import com.qa.business.service.TraineeAccountService;

@Path("/traineeAccount")
public class TraineeAccountEndpoint {

	@Inject
	private TraineeAccountService service;
	
	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllTraineeAccounts() {
		return service.getAllTraineeAccounts();
	}
	
	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String createAccount(String account) {
		return service.createTraineeAccount(account);
	}

	@Path("/deleteAccount/{TraineeID}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("traineeID") Long traineeID) {
		return service.deleteTraineeAccount(traineeID);
	}
	
	@Path("/updateAccount/{traineeID}")
	@POST
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("traineeID") Long traineeID, String traineeFullName) {
		return service.updateTraineeAccount(traineeID,traineeFullName);
	}

	public void setService(TraineeAccountService service) {
		this.service = service;
	}
}