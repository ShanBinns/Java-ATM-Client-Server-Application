/**
 * Account model class which handles all account communication with database using jdbc
 * @author SBINNS
 *
 */

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import database.JDBConnection;
import driver.Driver;



public class Account{
	private static final Logger logger = LogManager.getLogger(Account.class);
	
	private int accountNumber;
	private double accountBalance;	
	private	int custID;	
	
	 private Connection con;
	 private Statement stat = null;
	 private ResultSet result = null;	
	
	public Account() 
	{
		this.con = JDBConnection.getDatabaseConnection();  
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
		return "Account [accountNumber=" + accountNumber  + ", accountBalance="
				+ accountBalance + ", custID=" + custID + "]";
	}

	
		
	public double withdrawalTransaction(int id, double amount) {
		double newBalance = 0;
		double balance = 0.0;
		String sql1 = "SELECT * FROM mtabank.account Where accountNumber = '"+id+"'";
		logger.info("Attempting to Withdraw");
		try {
			
			stat = con.createStatement();
    		result = stat.executeQuery(sql1);
    		if(result.next())
    		{
    			balance = (result.getDouble(2));
    		}
			
		}catch(SQLException e)    	{
    		e.printStackTrace();
	    	}
		if(amount<100){
			logger.error("Insufficient Withdrawal Amount");
			JOptionPane.showMessageDialog(null,"The Minimum cash you can withdraw is 100","Transaction Status: Incomplete",JOptionPane.INFORMATION_MESSAGE);
		}
		else if(amount < balance) {
			newBalance = balance - amount;
			
			 String sql2 = "UPDATE mtabank.account SET accountBalance = ? Where accountNumber = ?";
		    	try
		    	{
		    		PreparedStatement ps = con.prepareStatement(sql2);
		    		ps.setDouble(1, newBalance);
		    		ps.setInt(2, id);
		    		int affectedRecords = ps.executeUpdate();
		    	}
		    	catch(SQLException e)
		    	{
		    		e.printStackTrace();
			    	}
		    	
		}else {
			JOptionPane.showMessageDialog(null, "Please Enter a Valid Amount", "Transaction Status: Incomplete", JOptionPane.ERROR_MESSAGE);
			logger.error("Invalid Withdrawal Amount");
		}
		return newBalance;
	}
	
	
	public double DepositTransaction(int id, double amount) {
		double newBalance = 0;
		double balance = 0.0;
		logger.info("Attempting to Deposit");
		String sql1 = "SELECT * FROM mtabank.account WHERE accountNumber = '"+id+"'";
		try {
			
			stat = con.createStatement();
    		result = stat.executeQuery(sql1);
    		if(result.next())
    		{
    			balance = (result.getDouble(2));
    		}
			
		}catch(SQLException e)    	{
    		e.printStackTrace();
	    	}
		
		
		newBalance = balance + amount;
		
		 String sql2 = "UPDATE mtabank.account SET accountBalance = ? Where accountNumber = ?";
	    	try
	    	{
	    		PreparedStatement ps = con.prepareStatement(sql2);
	    		ps.setDouble(1, newBalance);
	    		ps.setInt(2, id);
	    		int affectedRecords = ps.executeUpdate();
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
		    	}
			return newBalance;
	    	
	   }

	
	public int getAccountNumber(int custNumber) {
		int accNumber = 0 ;
		String sql1 = "SELECT * FROM mtabank.account WHERE custID = '"+custNumber+"'";
		try {
			
			stat = con.createStatement();
    		result = stat.executeQuery(sql1);
    		if(result.next())
    		{
    			accNumber = (result.getInt(1));
    		}
			
		}catch(SQLException e)    	{
    		e.printStackTrace();
	    	}		
		return accNumber;
	}
	
	
	public double getBalance(int accnum) {
		double balance = 0.0;
		String sql1 = "SELECT * FROM mtabank.account WHERE accountNumber = '"+accnum+"'";
		try {
			
			stat = con.createStatement();
    		result = stat.executeQuery(sql1);
    		if(result.next())
    		{
    			balance = (result.getDouble(2));
    		}
			
		}catch(SQLException e)    	{
    		e.printStackTrace();
	    	}
		return balance;
	}
		
	
}
