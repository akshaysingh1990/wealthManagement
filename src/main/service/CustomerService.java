package main.service;

import java.util.List;
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
	Scanner scanner = new Scanner(System.in);

	@Override
	public void create() {

		Customer customer = new Customer();
		System.out.println("==========Add Customer=======");
		System.out.println("Enter Name");

//		Scanner scanner = new Scanner(System.in);
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

		int totalCustomers = advisor.totalCustomers();
		customer.setId((long) totalCustomers + 1);

		// update customer in advisor
		List<Customer>  customers = advisor.getCustomers();

		// customers[wealthUtils.convertLongToInt(customer.getId())] = customer;
	//	customers[wealthUtils.convertLongToInt(customer.getId()) - 1] = customer;
        customers.add(customer);
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
		List<Advisor> advisors = advisorService.advisors;

		System.out.println("Id		Name   Age	 Amount  Advisor");
		for (Advisor advisor : advisors) {
			if (advisor != null) {
				List<Customer> customers = advisor.getCustomers();
				for (Customer customer : customers) {
					if (advisor != null && customer != null) {
						System.out.println(customer.getId() + "	" + customer.getName() + "   " + customer.getAge()
								+ "     " + customer.getTotalAmount() + "   " + advisor.getName());

					}
				}
			}
		}
	}

	@Override

	public void delete() {

		System.out.println("Enter AdvisorID");
		List<Advisor> advisors = advisorService.advisors;

	//	Scanner scanner2 = new Scanner(System.in);
		int option2 = scanner.nextInt();
		List<Customer> customer = advisors.get(option2 - 1).getCustomers();
		for (Customer customers : customer) {
			if (customers != null) {
				System.out.println(customers.getId() + "	" + customers.getName() + "   " + customers.getAge()
						+ "     " + customers.getTotalAmount() + "   " + advisors.get(option2 - 1).getName());
			}
		}
		System.out.println("Enter CustomerID");
		int option3 = scanner.nextInt();
	
		customer.remove(option3-1);
		advisors.add(option3 - 1,null);
	}

	public void edit() {

		System.out.println("You are only allowed to change the name of Customer");

		System.out.println("Enter AdvisorID");
		List<Advisor> advisors = advisorService.advisors;

//		Scanner scanner4 = new Scanner(System.in);

		int option4 = scanner.nextInt();
		List<Customer> customer = advisors.get(option4 - 1).getCustomers();
		for (Customer customers : customer) {
			if (customers != null) {
				System.out.println(customers.getId() + "	" + customers.getName() + "   " + customers.getAge()
						+ "     " + customers.getTotalAmount() + "   " + advisors.get(option4 - 1).getName());
			}
		}
		System.out.println("Enter CustomerID");
		int option5 = scanner.nextInt();
		System.out.println("Enter name of new customer");
		scanner.nextLine();
		String name4 = scanner.nextLine();

		customer.get(option5 - 1).setName(name4);

	}

}
