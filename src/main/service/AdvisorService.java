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
		advisors[wealthUtils.convertLongToInt((advisor.getId()-1))] = advisor;
	}

	@Override
	public void viewAll() {
		// TODO Auto-generated method stub

		System.out.println("Id 	Name	    Age	 Amount");
		for (Advisor advisor : advisors) {
			if (advisor != null) {
				System.out.println(
						advisor.getId()+"	"+advisor.getName() + "   " + advisor.getAge() + "     " + advisor.getTotalTransactionAmount());
			}
		}
	}

	public void delete() {
		
		System.out.println("Enter AdvisorID");
		Scanner scanner1 = new Scanner(System.in);

		int option1 = scanner1.nextInt();
		advisors[option1-1] = null;
		
		
		
		
		
	}
	
	public Advisor getAdvisorById(Long advisorId) {
		return advisors[wealthUtils.convertLongToInt(advisorId)-1];
	}

}

