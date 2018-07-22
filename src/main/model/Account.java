package main.model;

public class Account {

	public enum AccountType  {SAVINGS , CURRENT};
	private Long id;
	private String bankName;
	private AccountType accountType;
	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", bankName=" + bankName + ", accountType=" + accountType + ", amount=" + amount
				+ "]";
	}
}
