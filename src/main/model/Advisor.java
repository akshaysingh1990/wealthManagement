package main.model;

public class Advisor extends Person {
	
	private Customer[] customers;
	private Double totalTransactionAmount;
	private static Long countId = 0L;
	
	public Advisor() {
		countId++;
		this.setId(countId);
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
}
