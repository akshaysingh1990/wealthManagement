package main.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Advisor extends Person {
	
	private Set<Customer> customers = new HashSet();
	
	private Double totalTransactionAmount = 0.0;
	private static Long countId = 0L;
	
	public Advisor() {
		countId++;
		this.setId(countId);
//		customers = new Customer[length];
	}	

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public Double getTotalTransactionAmount() {
		return totalTransactionAmount;
	}

	public void setTotalTransactionAmount(Double totalTransactionAmount) {
		this.totalTransactionAmount = totalTransactionAmount;
	}
	
	
	public int totalCustomers() {
		int totalCustomers =0;
		for(Customer customer : customers)
		{
			if (customer != null) {
				totalCustomers = totalCustomers + 1;
				
			}
		}      return totalCustomers;
	}
	
	public Customer getCustomerById(Long Id) {
		Customer customerA =new Customer();
		for(Customer customer : customers) {
			if(customer.getId() == Id)
				{customerA = customer;}
		}return customerA;
		}
	
		

	
	@Override
	public String toString() {return null;}
//		return "Advisor [customers=" + Arrays.toString(customers) + ", totalTransactionAmount=" + totalTransactionAmount
//				+ ", Person=" + super.toString() + "]";
	}


