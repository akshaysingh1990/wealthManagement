package main.service;

import java.util.Scanner;

import main.model.Account;
import main.model.Advisor;
import main.model.Customer;

public class CustomerService implements CommonService{

	private AdvisorService advisorService ; 
	private AccountService accountService = new AccountService();
 	
	public CustomerService(AdvisorService advisorService_parameter) {
		advisorService = advisorService_parameter;
	}

	@Override
	public void create() {
		
		Customer customer = new Customer();
		System.out.println("==========Add Customer=======");
		System.out.println("Enter Name");
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		customer.setName(name);
		
		System.out.println("Enter Age");
		int age = scanner.nextInt();
		customer.setAge(age);
		
		System.out.println("Enter Advisor id");
		Long advisorId = scanner.nextLong();
		Advisor advisor = advisorService.getAdvisorById(advisorId);
		customer.setAdvisor(advisor);
		
		System.out.println("Create Account");
		Account[] accounts = new Account[5];
		Account account = accountService.create(customer.getId());
		accounts[0] = account;
		customer.setAccounts(accounts);
		Double totalAmount = 0.0d;
		for(Account singleAccount : accounts) {
			if(singleAccount != null) {
				totalAmount = totalAmount + singleAccount.getAmount();
			}
		}
		customer.setTotalAmount(totalAmount);
		
		//update customer in advisor
		Customer[] customers = advisor.getCustomers();
		customers[wealthUtils.convertLongToInt(customer.getId())] = customer;
		advisor.setCustomers(customers);
		System.out.println(advisor);
		System.out.println("=================");
		System.out.println(customer);
	}

	@Override
	public void viewAll() {
	
		//view all customer with total amount
	}
	
	

}
