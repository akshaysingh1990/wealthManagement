package main.controller;

import main.model.Advisor;
import main.model.Customer;
import main.service.AdvisorService;
import main.service.CustomerService;
import java.util.Scanner;

public class WealthManagement {

	private static AdvisorService advisorService = new AdvisorService();
	private static CustomerService customerService = new CustomerService(advisorService);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1 add advisor
		// 2 add customer
		// 3 Show all advisors
		// 4 Show all customers
		// view customer id --> all info 3
		// financial adviosr --> list all customer and their amount 4
		//

		// advisorService.create();
		// customerService.create();

		Advisor advisor1 = new Advisor(2);
		advisor1.setAge(20);
		advisor1.setName("advisor 1");
		advisor1.setTotalTransactionAmount(10000.0d);
		Advisor advisor2 = new Advisor(2);
		advisor2.setAge(21);
		advisor2.setName("advisor 2");
		advisor2.setTotalTransactionAmount(20000.0d);

		Customer customer1 = new Customer();
		customer1.setName("customer 1");
		customer1.setAge(15);
		customer1.setAdvisor(advisor1);
		customer1.setTotalAmount(1000d);

		Customer customer2 = new Customer();
		customer2.setName("customer 2");
		customer2.setAge(16);
		customer2.setAdvisor(advisor1);
		customer2.setTotalAmount(2000d);

		Customer customersA[] = new Customer[10];
		customersA[0] = customer1;
		customersA[1] = customer2;
		// Customer customerAdvisor1[] = { customer1, customer2 };
		advisor1.setCustomers(customersA);

		Customer customer3 = new Customer();
		customer3.setName("customer 3");
		customer3.setAge(8);
		customer3.setAdvisor(advisor2);
		customer3.setTotalAmount(3000d);

		Customer customer4 = new Customer();
		customer4.setName("customer 4");
		customer4.setAge(9);
		customer4.setAdvisor(advisor2);
		customer4.setTotalAmount(4000d);

		Customer customersB[] = new Customer[10];
		customersB[0] = customer3;
		customersB[1] = customer4;
		// Customer customerAdvisor1[] = { customer1, customer2 };
		advisor2.setCustomers(customersB);
		// Customer customerAdvisor2[] = { customer3, customer4 };
		// advisor2.setCustomers(customerAdvisor2);

		// advisorService.advisors[] = {advisor1 , advisor2};

		advisorService.advisors[0] = advisor1;
		advisorService.advisors[1] = advisor2;

		for (int i = 0; i < 100;) {
			System.out.println("Press 1 to view details of all advisors");
			System.out.println("Press 2 to view details of all customers");
			System.out.println("Press 3 to add details for new advisor");
			System.out.println("Press 4 to add details for new customers");
			System.out.println("Press 5 to delete  advisor");
			System.out.println("Press 6 to delete  customer");
			// VERY IMPORTANT NOTE : When you add the new advisor it is not added
			// sequentially at next position(
			// at [2] it is added on the next place according to indexing done in count++
			Scanner scanner = new Scanner(System.in);
			int choice = scanner.nextInt();
			if (choice == 1) {
				advisorService.viewAll();
			} else if (choice == 2) {
				customerService.viewAll();
			} else if (choice == 3) {
				advisorService.create();
			} else if (choice == 4) {
				customerService.create();
			} else if (choice == 5) {
				
				
				advisorService.delete();
			} else if (choice == 6) {
				customerService.delete();
			}

			else {
				System.out.println("you enter the wrong details");

			}
			System.out.println("Press enter to continue the application");
			scanner.nextLine();
			String name = scanner.nextLine();
			if (name.equals("")) {
				i++;
			} else {
				break;
			}

		}

	}
}
