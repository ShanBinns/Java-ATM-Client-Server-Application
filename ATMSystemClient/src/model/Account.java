package model;


public class Account {


	private int accountNumber;
	private double accountBalance;
	
	private	int custID;
	
	
	public Account() 
	{
	
        this.accountNumber = 0;
        this.accountBalance = 0.0;
        this.custID = 0;
	}
	
	public Account(int accountNumber, double accountBalance, int custID) {
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.custID = custID;
	}


	public int getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	
	
	
	public int getCustID() {
		return custID;
	}

	public void setCustID(int custID) {
		this.custID = custID;
	}
	
	

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountBalance="
				+ accountBalance + ", custID=" + custID + "]";
	}

			
	
}
