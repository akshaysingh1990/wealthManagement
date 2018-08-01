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

		// customers[wealthUtils.convertLongToInt(customer.getId())] = customer;
		customers[advisor.totalCustomers()] = customer;

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

		System.out.println("Id		Name   Age	 Amount  Advisor");
		for (Advisor advisor : advisors) {
			if (advisor != null) {
				Customer[] customer = advisor.getCustomers();
				for (int i =0 ;i < customer.length; i++) {
					if (advisor != null && customer[i] != null) {
						System.out.println(i+1 + "	" + customer[i].getName() + "   " + customer[i].getAge()
								+ "     " + customer[i].getTotalAmount() + "   " + advisor.getName());

					}
				}
			}
		}
	}

	public void delete() {

		System.out.println("Enter AdvisorID");
		Advisor[] advisors = advisorService.advisors;

		Scanner scanner2 = new Scanner(System.in);
		int option2 = scanner2.nextInt();
		Customer[] customer = advisors[option2 - 1].getCustomers();
		for (int i =0; i < customer.length; i++) {
			if (customer[i] != null) {
				System.out.println(i+1 + "	" + customer[i].getName() + "   " + customer[i].getAge() + "     "
						+ customer[i].getTotalAmount() + "   " + advisors[option2 - 1].getName());
			}
		}
		System.out.println("Enter CustomerID");
		int option3 = scanner2.nextInt();
           customer[option3-1] = null;
	
	
	}

}
