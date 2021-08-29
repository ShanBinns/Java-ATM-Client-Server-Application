/**
 * Multi-Threaded Server Engine
 * @author SBINNS
 *
 */
package network;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import driver.Driver;
import model.Account;
import model.Customer;
import model.SessionInfo;
import view.ReceiptView;

public class ServerEngine implements Runnable{
	private static final Logger logger = LogManager.getLogger(ServerEngine.class);
	private ObjectOutputStream os;
    private ObjectInputStream is;
    private Socket connection;
    private String action;
	
	
    public ServerEngine(Socket connection) {
        this.connection = connection;
        System.out.println("Server Thread started at: " + new Date());
        (new Thread(this)).start();
    }
	
	
    private void getStreams(){
        try{
            
            os = new ObjectOutputStream(connection.getOutputStream());
            is = new ObjectInputStream(connection.getInputStream());
        }
        catch(IOException ex){
        	 ex.printStackTrace();
        }
        catch(Exception ex){
        	 ex.printStackTrace();
        }
    }
    
    private void closeConnection(){
        try{
          os.close();
          is.close();
          connection.close();
        }
        catch(IOException ex){
        	ex.printStackTrace();
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
    }
    

	@Override
	public void run() {
		 action =null;
	        try{
	                this.getStreams();
	                do{
	                	logger.info("Attemtping to read from stream.");
	                    action = (String) is.readObject();
	                    System.out.println("Reading from stream sucessful.");
	                    switch(action)
	                    {
	                        case "getCustomers":  {
	                        	logger.info("Attemtping to write to stream, errors may occur.");
	                            os.writeObject(new Customer().selectAllCustomers());
	                            System.out.println("Writing to stream sucessful.");
	                        }
	                        break;
	                        case "getAccount":  {
	                        	logger.info("Attemtping to write to stream, errors may occur.");
	                        	int customerNumber = (Integer)is.readObject();
	                            os.writeObject(new Account().getAccountNumber(customerNumber));
	                            System.out.println("Writing to stream sucessful.");
	                        }
	                        break;
	                        case "getPin":  {
	                        	logger.info("Attemtping to write to stream, errors may occur.");
	                        	 int accNum = (Integer)is.readObject();
	                             os.writeObject(new Customer().findCustomerById(accNum)); 
	                                                                                          
	                            System.out.println("Writing to stream sucessful.");
	                        }
	                        break;
	                        case "setSession":  {   
	                        	logger.info("Attemtping to write to stream, errors may occur.");
	                        	 int accountNum = (Integer)is.readObject();
	                        	 int id = 1;
	                             os.writeObject(new SessionInfo().setSessionInfo(accountNum, id)); 
	                                                                                          
	                            System.out.println("Writing to stream sucessful.");
	                        }
	                        break;
	                        case "getSession":  {
	                        	logger.info("Attemtping to write to stream, errors may occur.");
	                        	os.writeObject(new SessionInfo().getSessionInfo()); 
	                                                                                          
	                            System.out.println("Writing to stream sucessful.");
	                        }
	                        break;
	                        case "withdrawal":  {
	                        	logger.info("Attemtping to write to stream, errors may occur.");
	                        	 int accNum = (Integer)is.readObject();
	                        	 double amount = (double)is.readObject();
	                             os.writeObject(new Account().withdrawalTransaction(accNum, amount)); 
	                                                                                          
	                             logger.info("Writing to stream sucessful.");
	                        }
	                        break;
	                        case "deposit":  {
	                        	logger.info("Attemtping to write to stream, errors may occur.");
	                        	 int accNum = (Integer)is.readObject();
	                        	 double amount = (double)is.readObject();
	                             os.writeObject(new Account().DepositTransaction(accNum, amount)); 
	                                                                                          
	                             logger.info("Writing to stream sucessful.");
	                        }
	                        break;
	                        case "getBalance":  {
	                        	logger.info("Attemtping to write to stream, errors may occur.");
	                        	int accNum = (Integer)is.readObject();
	                             os.writeObject(new Account().getBalance(accNum)); 
	                             
	                             logger.info("Writing to stream sucessful.");
	                        }
	                        break;
	                        case "printReceipt":  {
	                        	logger.info("Attemtping to write to stream, errors may occur.");
	                        	 String transaction = (String)is.readObject();
	                        	 double amount = (double)is.readObject();
	                        	 double balance = (double)is.readObject();
	                        	 
	                             ReceiptView rec = new ReceiptView(transaction, amount, balance);	                                                        
	                             logger.info("Writing to stream sucessful.");
	                        }
	                        break;
	                    }//End of switch
	                }while(!action.equals("Exit"));
	                	this.closeConnection();
	        }//End of try
	        catch(EOFException ex){
	            ex.printStackTrace();
	        }
	        catch(IOException ex){
	        	ex.printStackTrace();
	        }
	        catch(ClassNotFoundException ex){
	        	ex.printStackTrace();
	        }
	        catch(ClassCastException ex){
	        	ex.printStackTrace();
	        }
	        catch(Exception ex){
	        	ex.printStackTrace();
	        }
	   
	}

}
