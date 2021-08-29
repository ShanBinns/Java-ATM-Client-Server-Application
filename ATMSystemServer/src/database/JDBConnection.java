/**
 *  This class is the handling the communication with database Apache MySQL using Java Database Connection
 * @author SBINNS
 *
 */

package database;

import java.sql.*;

import javax.swing.JOptionPane;

public class JDBConnection {
	private static Connection con = null;
	
	public static Connection getDatabaseConnection() {
		String url = "jdbc:mysql://localhost:3306/mtabank";
		Connection con = null;
		
		if(con == null) 
		{
			try {
				con = DriverManager.getConnection(url, "root", "");
				if(con != null){					
					//JOptionPane.showMessageDialog(null, "Connected to local server", "JDBC Connection Status", JOptionPane.INFORMATION_MESSAGE);
				} 
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return con;
			
	
	}

}
