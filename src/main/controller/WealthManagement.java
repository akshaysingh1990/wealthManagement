package main.controller;

import main.service.AdvisorService;
import main.service.CustomerService;

public class WealthManagement {

	private static AdvisorService advisorService = new AdvisorService();
	private static CustomerService customerService = new CustomerService(advisorService);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//2 add advisor 
		//1 add customer 
		// view customer id --> all info 3 
		//financial adviosr --> list all customer and their amount 4 
		//
//		CustomerService customerService = new CustomerService();
//		customerService.create();
		advisorService.create();
		customerService.create();
		
		
 	}

}
