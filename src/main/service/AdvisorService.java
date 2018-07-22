package main.service;

import java.util.Scanner;

import main.model.Advisor;

public class AdvisorService implements CommonService {

	static Advisor[]  advisors = new Advisor[10];
	
	@Override
	public void create() {
		Advisor advisor = new Advisor();
		System.out.println("==========Add Advisor=======");
		System.out.println("Enter Name");
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		advisor.setName(name);
		
		System.out.println("Enter Age");
		int age = scanner.nextInt();
		advisor.setAge(age);

		System.out.println(advisor);
		advisors[convertAdvisorIdFromLongToInt(advisor.getId())] = advisor;
	}

	@Override
	public void viewAll() {
		// TODO Auto-generated method stub

	}

	public Advisor getAdvisorById(Long advisorId) {
		
		return advisors[convertAdvisorIdFromLongToInt(advisorId)];
	}
	
	private int convertAdvisorIdFromLongToInt(Long id) {
		return (int) (long)id;
	}

}
