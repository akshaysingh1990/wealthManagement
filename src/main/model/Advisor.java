package main.model;

import java.util.Arrays;

public class Advisor extends Person {
	
	private Customer[] customers;
	private Double totalTransactionAmount = 0.0;
	private static Long countId = 0L;
	//private int length = .length; 
	private int totalCustomers = 0;
	
	
	public Advisor(int length) {
		countId++;
		this.setId(countId);
		customers = new Customer[length];
	}	

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}

	public Double getTotalTransactionAmount() {
		return totalTransactionAmount;
	}

	public void setTotalTransactionAmount(Double totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}
	
	
	public int totalCustomers() {
		for(Customer customer : customers)
		{
			if (customer != null) {
				totalCustomers = totalCustomers + 1;
				
			}
		}      return totalCustomers;
	}
	@Override
	public String toString() {
		return "Advisor [customers=" + Arrays.toString(customers) + ", totalTransactionAmount=" + totalTransactionAmount
				+ ", Person=" + super.toString() + "]";
	}

}
