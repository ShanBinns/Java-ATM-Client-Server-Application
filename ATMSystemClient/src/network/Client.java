/**
 * This class is responsible for handling client processes, such as sending action and objects to server
 * @author SBINNS
 *
 */

package network;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import model.Customer;

public class Client implements Serializable{
	
	private static final Logger logger = LogManager.getLogger(Client.class);
	
	private ObjectInputStream is;
    private ObjectOutputStream os;
    private Socket connection;
    private Socket socket;
    
    public Client()
    {
    	
        this.createConnection();
        this.configureStreams();   
    }
    
    public void createConnection()
    {
        try
        {
            this.connection = new Socket("127.0.0.1", 8888);
           logger.info("Client Connection Established with Server");
        }
        catch(UnknownHostException ex)
        {
            ex.printStackTrace();
        }
        catch(IOException ex)
        {
            ex.printStackTrace();;
        }
    }
    
    public void configureStreams()
    {
        try
        {
            this.os = new ObjectOutputStream(connection.getOutputStream());
            this.is = new ObjectInputStream(connection.getInputStream());
           logger.info("Client Streams Established with Server Streams");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();;
        }
    }
    
    public void closeStreams()
    {
        try
        {
            os.close();
            is.close();
            connection.close();
           logger.info("Client ends connection with server");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
       
    public void sendAction(String action)
    {
        try
        {
            os.writeObject(action);
           logger.info("Client sends action to server");
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
        catch(Exception ex){
        	ex.printStackTrace();
        }
    }
    
    public void sendAmount(Object obj){
        try{
           os.writeObject(obj);  
          logger.info("Writing to stream successful."); 
         }
       
         catch(Exception ex){
        	logger.info(ex.getMessage());
         } 
     }
    
    public void sendSessionInfo(int num){  //Update
        try{
           os.writeObject(num);  
          logger.info("Writing to stream successful."); 
         }
       
         catch(Exception ex){
        	logger.info(ex.getMessage());
         } 
     }
    
    public void sendAccountNum(int num){  
        try{
            os.writeObject(num);
            }
        catch(IOException ex){
        	System.out.println(ex.getMessage()); 
        	}
        catch(Exception ex){
        	System.out.println(ex.getMessage());       
        	}
        }
    
    public void sendTransaction(Object obj){
        try{
           os.writeObject(obj);  
          logger.info("Writing to stream successful."); 
         }
       
         catch(Exception ex){
        	logger.info(ex.getMessage());
         } 
     }
    
    
    public Object receiveResponse(){
        Object obj = null;
        try{
           obj = is.readObject(); 
           
          logger.info("Reading from server stream successful."); 
        }
        catch(ClassCastException ex){
        	System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex){
        	System.out.println(ex.getMessage());
        }
      catch(Exception ex){
        	System.out.println(ex.getMessage());
        }
        return obj;
    }   
    
    public int receiveInt(){
        int obj = 0;
        try{
           obj = (int) is.readObject(); 
           
          logger.info("Reading from server stream successful."); 
        }
        catch(ClassCastException ex){
        	System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex){
        	System.out.println(ex.getMessage());
        }
      catch(Exception ex){
        	System.out.println(ex.getMessage());
        }
        return obj;
    }   
    
    
    public double receiveBalance(){
    	double obj = 0.0;
        try{
           obj = (double) is.readObject(); 
           
          logger.info("Reading from server stream successful."); 
        }
        catch(ClassCastException ex){
        	System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex){
        	System.out.println(ex.getMessage());
        }
      catch(Exception ex){
        	System.out.println(ex.getMessage());
        }
        return obj;
    }   
    
    public int receiveSessionInfo(){
        int obj = 0;
        try{
           obj = (int) is.readObject(); 
           
          logger.info("Reading from server stream successful."); 
        }
        catch(ClassCastException ex){
        	System.out.println(ex.getMessage());
        }
        catch(ClassNotFoundException ex){
        	System.out.println(ex.getMessage());
        }
      catch(Exception ex){
        	System.out.println(ex.getMessage());
        }
        return obj;
    }   
    
    
}
