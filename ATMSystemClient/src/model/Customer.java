package model;

public class Customer {
	
	private int customerID;
	private String firstName;
	private String lastName;
	private	int pin;
	
	public Customer() 
	{
        this.customerID = 0;
        this.firstName = "";
        this.lastName = "";
        this.pin = 0;
	}
	
	public Customer(int customerID, String firstName, String lastName, int pin) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.pin = pin;
	}
	
	public Customer(String firstName, String lastName, int pin) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.pin = pin;
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}
	
	
	
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", pin="
				+ pin + "]";
	}


}

