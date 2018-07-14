package main.controller;

import main.service.AdvisorService;
import main.service.CustomerService;

public class WealthManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//2 add advisor 
		//1 add customer 
		// view customer id --> all info 3 
		//financial adviosr --> list all customer and their amount 4 
		//
//		CustomerService customerService = new CustomerService();
//		customerService.create();
		AdvisorService advisorService = new AdvisorService();
		advisorService.create();
 	}

}
