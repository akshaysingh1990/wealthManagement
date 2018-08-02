package main.service;

import java.util.Scanner;

import main.model.Advisor;
import main.utils.WealthUtils;

public class AdvisorService implements CommonService {

	public Advisor[] advisors = new Advisor[10];

	@Override
	public void create() {
		Advisor advisor = new Advisor(10);
		System.out.println("==========Add Advisor=======");
		System.out.println("Enter Name");

		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		advisor.setName(name);

		System.out.println("Enter Age");
		int age = scanner.nextInt();
		advisor.setAge(age);

		// System.out.println(advisor);
		advisors[wealthUtils.convertLongToInt((advisor.getId() - 1))] = advisor;
	}

	@Override
	public void viewAll() {
		// TODO Auto-generated method stub

		System.out.println("Id 	Name	    Age	 Amount");
		for (Advisor advisor : advisors) {
			if (advisor != null) {
				System.out.println(advisor.getId() + "	" + advisor.getName() + "   " + advisor.getAge() + "     "
						+ advisor.getTotalTransactionAmount());
			}
		}
	}

	public void delete() {

		System.out.println("Enter AdvisorID");
		Scanner scanner1 = new Scanner(System.in);

		int option1 = scanner1.nextInt();
		advisors[option1 - 1] = null;

	}

	public void edit() {

		System.out.println("You are only allowed to change the name of Advisor");

		System.out.println("Enter AdvisorID");
		Scanner scanner3 = new Scanner(System.in);

		int option3 = scanner3.nextInt();

		System.out.println("Enter name of new advisor");
		scanner3.nextLine();
		String name3 = scanner3.nextLine();

		advisors[option3 - 1].setName(name3);

	}

	public Advisor getAdvisorById(Long advisorId) {
		return advisors[wealthUtils.convertLongToInt(advisorId) - 1];
	}

}
