package main.service;

import java.util.Scanner;

import main.model.Account;
import main.model.Advisor;
import main.model.Customer;

public class CustomerService implements CommonService{

	private AdvisorService advisorService = new AdvisorService();
	private AccountService accountService = new AccountService();
 	
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
		
		System.out.println(customer);
	}

	@Override
	public void viewAll() {
	
		//view all customer with total amount
	}
	
	

}
