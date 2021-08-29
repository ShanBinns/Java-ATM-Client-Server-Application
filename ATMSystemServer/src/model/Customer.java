/**
 * Customer model class which handles all customer information communication with database using jdbc
 * @author SBINNS
 *
 */
package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.JDBConnection;

public class Customer {
	
	private int customerID;
	private String firstName;
	private String lastName;
	private	int pin;
	
	 private Connection con;
	 private Statement stat = null;
	 private ResultSet result = null;
	    
	    
	
	public Customer() 
	{
		this.con = JDBConnection.getDatabaseConnection();  
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

	
    public Object selectAllCustomers(){ 
    	System.out.println("Hi, in method");
    	List<Customer> customerList = new ArrayList();
    	String sql = "SELECT * FROM mtabank.customer";
    	try
    	{
    		stat = con.createStatement();
    		result = stat.executeQuery(sql);
    		while(result.next())
    		{
    			Customer customer = new Customer();
    			customer.setCustomerID(result.getInt(1));
    			customer.setFirstName(result.getString(2));
    			customer.setLastName(result.getString(3));
    			customer.setPin(result.getInt(4));
    			customerList.add(customer);
    		}
    	
    	}catch (SQLException ex) {
        	 ex.printStackTrace();
        }
        catch(Exception ex){
        	 ex.printStackTrace();
        }
    	System.out.println(customerList);
         return (ArrayList<Customer>) customerList;
    }
	
    
	
	public int findCustomerById(int num)
    {
		int pin = 0;
		
    	String sql = "SELECT * FROM mtabank.customer where customerID = '"+num+"'";
    	try
    	{
    		stat = con.createStatement();
    		result = stat.executeQuery(sql);
    		while(result.next())
    		{
    			pin = (result.getInt(4));
    		}
    	}
    	catch(SQLException e)
    	{
    		
    	}
		return pin;
    }
	


}

