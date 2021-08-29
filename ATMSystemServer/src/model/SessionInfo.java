/**
 * Session model class used to maintain session persistence while the program runs
 * @author SBINNS
 *
 */
package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import database.JDBConnection;

public class SessionInfo{
	
	   private static final Logger logger = LogManager.getLogger(SessionInfo.class);
	   private int cardNumber;
	   private int sessionID;
	   private Connection con;
	   private Statement stat = null;
	   private ResultSet result = null;	
		
	   
	   public SessionInfo(int cardNumber, int sessionID) {
	        this.cardNumber = cardNumber;
	        this.cardNumber = cardNumber;
	    }
	   
	   public SessionInfo() {
		   this.con = JDBConnection.getDatabaseConnection();  
	        this.cardNumber = 0;
	        this.sessionID = 0;
	    }

	    public void setCardNumber(int cn) {
	        this.cardNumber = cn;
	    }
	  
	    public int getCardNumber() {
	        return cardNumber;
	    }


		@Override
		public String toString() {
			return "SessionInfo [cardNumber=" + cardNumber + "]";
		}
	    
	    
		public int getSessionInfo() {
			int accountNumber = 0;
			String sql = "SELECT * FROM mtabank.session";
			try {
				
				stat = con.createStatement();
	    		result = stat.executeQuery(sql);
	    		if(result.next())
	    		{
	    			accountNumber = (result.getInt(2));
	    		}
				
			}catch(SQLException e)    	{
	    		e.printStackTrace();
		    	}
			
			return accountNumber;
		}
		
		
			public int setSessionInfo(int CardNum, int ID) {
			String sql = "UPDATE mtabank.session SET CardNumber = ? Where SessionID = ?";
			try
	    	{
	    		PreparedStatement ps = con.prepareStatement(sql);
	    		
	    		ps.setInt(1, CardNum);
	    		ps.setInt(2, ID);
	    		int affectedRecords = ps.executeUpdate();
	    	}
	    	catch(SQLException e)
	    	{
	    		e.printStackTrace();
		    	}
			
			logger.info("User Session Updated");
			return CardNum;
		}

}
