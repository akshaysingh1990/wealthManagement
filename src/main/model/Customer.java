package main.model;

import java.util.Arrays;

public class Customer extends Person {

	private Double totalAmount = 0.0d;
	private Account[] accounts;
	private Advisor advisor;

	public Customer() {
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
