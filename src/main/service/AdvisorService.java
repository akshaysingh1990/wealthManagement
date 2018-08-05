package main.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import main.model.Advisor;
import main.model.Customer;
import main.utils.WealthUtils;

public class AdvisorService implements CommonService {

//	public Advisor[] advisors = new Advisor[10];
	public List<Advisor> advisors = new ArrayList<Advisor>();
    private	Scanner scanner = new Scanner(System.in);

	@Override
	public void create() {
		Advisor advisor = new Advisor();
		System.out.println("==========Add Advisor=======");
		System.out.println("Enter Name");

	//	Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		advisor.setName(name);

		System.out.println("Enter Age");
		int age = scanner.nextInt();
		advisor.setAge(age);

		
		advisors.add(advisor);
		// System.out.println(advisor);
	//	advisors[wealthUtils.convertLongToInt((advisor.getId() - 1))] = advisor;
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
	//	Scanner scanner1 = new Scanner(System.in);

		int option1 = scanner.nextInt();
		advisors.remove(option1-1);
		advisors.add(option1 - 1,null);
	

	}

	public void edit() {

		System.out.println("You are only allowed to change the name of Advisor");

		System.out.println("Enter AdvisorID");
	//	Scanner scanner3 = new Scanner(System.in);

		int option3 = scanner.nextInt();

		System.out.println("Enter name of new advisor");
		scanner.nextLine();
		String name3 = scanner.nextLine();

		advisors.get(option3 - 1).setName(name3);

	}
	
	public void getAll() {
		
		Map<Advisor, List<Customer> > allInfo = new HashMap<>();
	       for(Advisor advisor : advisors) {
	    	   allInfo.put(advisor,  advisor.getCustomers());
	       }
	       
	       System.out.println("Advisor 	Customer");
//	       for(Advisor advisor : advisors) {
//	    	   
//	    	   List<Customer> customers = allInfo.get(advisor);
//	    	   for (Customer customer : customers)
//	    	   {
//	    	   System.out.println(advisor.getName()+"	"+customer.getName());
//	       }
//	       
	       for(Map.Entry<Advisor, List<Customer> > entry : allInfo.entrySet()) {
	    	   List<Customer> customers = entry.getValue();
	    	   for (Customer customer : customers) {
	    	   
	    	    System.out.println(entry.getKey().getName() + "    " + customer.getName());

	    	   }
	       }
	}

	public Advisor getAdvisorById(Long advisorId) {
		return advisors.get(wealthUtils.convertLongToInt(advisorId) - 1);
	}

}
