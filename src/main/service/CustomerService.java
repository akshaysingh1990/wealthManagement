package main.service;

import java.util.Scanner;

import main.model.Account;
import main.model.Advisor;
import main.model.Customer;

public class CustomerService implements CommonService {

	private AdvisorService advisorService;
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
		for (Account singleAccount : accounts) {

			if (singleAccount != null) {
				totalAmount = totalAmount + singleAccount.getAmount();
			}
		}
		customer.setTotalAmount(totalAmount);

		// update customer in advisor
		Customer[] customers = advisor.getCustomers();
		customers[wealthUtils.convertLongToInt(customer.getId())] = customer;
		advisor.setCustomers(customers);

		// update total transaction amount of advisor
		Double totalTransactionAmount = 0.0d;
		for (Customer singleCustomer : customers) {
			if (singleCustomer != null)
				totalTransactionAmount = totalTransactionAmount + singleCustomer.getTotalAmount();
		}
		advisor.setTotalTransactionAmount(totalTransactionAmount);
		// System.out.println(advisor);
	}

	@Override
	public void viewAll() {

		// view all customer with total amount
		Advisor[] advisors = advisorService.advisors;

		System.out.println("Name	    Age	 Amount  Advisor");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				
				
				
				if (advisors[i] != null && advisors[i].getCustomers()[j] != null) {
					System.out.println(advisors[i].getCustomers()[j].getName() + "   "
							+ advisors[i].getCustomers()[j].getAge() + "     "
							+ advisors[i].getCustomers()[j].getTotalAmount() + "   " + advisors[i].getName());

				}
			}
		}
	}

}
