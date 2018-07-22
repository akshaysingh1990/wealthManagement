package main.service;

import java.util.Scanner;

import main.model.Account;
import main.model.Account.AccountType;
import main.model.Customer;

public class AccountService {

	public Account create(Long customerId) {
		
		Account account = new Account();
		System.out.println("==========Add Account=======");
		System.out.println("Enter Account id");
		
		Scanner scanner = new Scanner(System.in);
		Long accountId = scanner.nextLong();
		account.setId(accountId);
		
		System.out.println("Enter Bank Name");
		scanner.nextLine();
		String bankName = scanner.nextLine();
		account.setBankName(bankName);
		
		System.out.println("Enter Amount");
		Double amount = scanner.nextDouble();
		account.setAmount(amount);
		
		account.setAccountType(AccountType.SAVINGS);
		System.out.println(account);
		return account;
		
		
	}
	
}
