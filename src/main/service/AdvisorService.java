package main.service;

import java.util.Scanner;

import main.model.Advisor;
import main.utils.WealthUtils;

public class AdvisorService implements CommonService {

	public Advisor[]  advisors = new Advisor[10];
	
	@Override
	public void create() {
		Advisor advisor = new Advisor(5);
		System.out.println("==========Add Advisor=======");
		System.out.println("Enter Name");
		
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		advisor.setName(name);
		
		System.out.println("Enter Age");
		int age = scanner.nextInt();
		advisor.setAge(age);

	//	System.out.println(advisor);
		advisors[wealthUtils.convertLongToInt((advisor.getId()))] = advisor;
	}

	@Override
	public void viewAll() {
		// TODO Auto-generated method stub
		
		
		System.out.println("Name	    Age	 Amount" );
		for(int i = 0; i<4 ; i++)
		{if(advisors[i] != null)	
		{System.out.println(advisors[i].getName()+ "   "+ advisors[i].getAge()+ "     " +advisors[i].getTotalTransactionAmount()) ;
		}}
	}

	public Advisor getAdvisorById(Long advisorId) {
		return advisors[wealthUtils.convertLongToInt(advisorId)];
	}
	
}
