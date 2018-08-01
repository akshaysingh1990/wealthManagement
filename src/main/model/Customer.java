package main.model;

import java.util.Arrays;

public class Customer extends Person {

	private Double totalAmount = 0.0d;
	private Account[] accounts;
	private Advisor advisor;
	private  Long countId = 0L;

	public Customer() {
		countId++;                  /// ENDED UP BEING IRRELEVANT SINCE CANT CREATE THE CUSTOMER ARRAY IN ITSELF
		this.setId(countId);
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public Advisor getAdvisor() {
		return advisor;
	}

	public void setAdvisor(Advisor advisor) {
		this.advisor = advisor;
	}

	@Override
	public String toString() {
		return "Customer [totalAmount=" + totalAmount + ", accounts=" + Arrays.toString(accounts) + ", advisor="
				+ advisor.getName() + ", Person=" + super.toString() + "]";
	}

}
